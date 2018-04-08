package com.personal.test.formatphone;

import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import java.io.File;

public class Options extends AppCompatActivity {

    Button formatBtn, takePhoto;
    private final int REQUEST_CODE_CAMERA_IMAGE = 1000;
    private final int REQUEST_CODE_EXTERNAL_IMAGE = 2000;
    static final int ACTIVATION_REQUEST = 1;
    DevicePolicyManager mDPM;
    ComponentName mDeviceAdmin;

    private void DeleteRecursive(File dir) {
        Toast.makeText(getApplicationContext(),"dir:" + dir,Toast.LENGTH_SHORT).show();
        if ( dir.isDirectory() )
        {
            Toast.makeText(getApplicationContext(),"dir:" + dir+"\nhidden:"+dir.isHidden()
                    +"\n"+"readable:" + dir.canRead(),Toast.LENGTH_SHORT).show();
            File[] children = dir.listFiles();

            Toast.makeText(getApplicationContext(),"children\n" + children,Toast.LENGTH_SHORT).show();
            for ( int i = 0 ; i < children.length ; i ++ )
            {
                File child =    children[i];
                if(child.isDirectory()){
                    System.out.println("child:" + child +"is a directory");
                    DeleteRecursive( child );
                    child.delete();
                }else{
                    System.out.println("child:" + child +"is a file");
                    child.delete();

                }
            }
            dir.delete();
        }else{
            Toast.makeText(getApplicationContext(),dir + " is a file",Toast.LENGTH_SHORT).show();
            dir.delete();
        }
    }
// Android storage https://developer.android.com/training/data-storage/files.html
    private void deleteAll(){
      //  File mediaDir = Environment.getExternalStoragePublicDirectory(
             //   Environment.DIRECTORY_PICTURES);

        File mediaDir = new  File("/sdcard/Pictures");

        File pictureDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);

        File exFilesDir = getApplicationContext().getExternalFilesDir(
                Environment.DIRECTORY_PICTURES);

        File filesDir = getApplicationContext().getFilesDir();

        File cacheDir = getApplicationContext().getCacheDir();

        try{
            DeleteRecursive(mediaDir);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();

        }

/*        try{
            DeleteRecursive(pictureDir);
        }catch (Exception e){}

        try{
            DeleteRecursive(exFilesDir);
        }catch (Exception e){}

        try{
            DeleteRecursive(filesDir);
        }catch (Exception e){}

        try{
            DeleteRecursive(cacheDir);
        }catch (Exception e){}*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{"READ_EXTERNAL_STORAGE", "WRITE_EXTERNAL_STORAGE"},ActivityCompat.THIS_REQUEST_CODE);

        formatBtn = (Button)findViewById(R.id.deletePhotobtn);
//        takePhoto = (Button)findViewById(R.id.takePhotobtn);
////select picture from external storage
        formatBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //TODO format
//                mDPM = (DevicePolicyManager)getSystemService(Context.DEVICE_POLICY_SERVICE);
//                mDeviceAdmin = new ComponentName(Options.this,      WipeDataReceiver.class);
//  //              mDeviceAdmin = new ComponentName();
//                Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
//                intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, mDeviceAdmin);
//                intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "Formating phone!!");
//                startActivityForResult(intent, ACTIVATION_REQUEST);
// //               Toast.makeText(getApplicationContext(),"format Successfully",Toast.LENGTH_SHORT).show();
//                mDPM.wipeData(ACTIVATION_REQUEST);
                try {
                    //String path = Environment.getExternalStorageDirectory().getPath();
                    File path = getApplicationContext().getFilesDir();
                    //DeleteRecursive(new File("/data"));
                    //DeleteRecursive(path);
                    deleteAll();
                    Toast.makeText(getApplicationContext(),"format Successfully",Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),"format error" +"\n" + e.getMessage(),Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });
//
//        //take picture from camera
//        takePhoto.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                // start camera to take picture
//                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//                intent.putExtra(MediaStore.EXTRA_OUTPUT, setImageUri());
//                startActivityForResult(intent,
//                        REQUEST_CODE_CAMERA_IMAGE);
//
//            }
//        });




    }

    public void gotoGetPhotos(View view) {
        Intent intentGotoGetPhoto = new Intent(this,GetPhotos.class);
        startActivity(intentGotoGetPhoto);
    }

    public void gotoTakePhoto(View view) {
        Intent intentGotoTakePhoto = new Intent(this,TakePhoto.class);
        startActivity(intentGotoTakePhoto);
    }
       /* public Uri setImageUri() {
            // Store image in dcim
            File file = new File(Environment.getExternalStorageDirectory() +"/android/data/spaj_foto/spaj_foto("+counter+").png");
            Uri imgUri = Uri.fromFile(file);
            this.imgPath = file.getAbsolutePath();
            return imgUri;
        }

    }*/

}
