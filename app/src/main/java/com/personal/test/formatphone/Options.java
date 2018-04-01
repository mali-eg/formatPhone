package com.personal.test.formatphone;

import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);


        formatBtn = (Button)findViewById(R.id.deletePhotobtn);
//        takePhoto = (Button)findViewById(R.id.takePhotobtn);
////select picture from external storage
        formatBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //TODO format
                mDPM = (DevicePolicyManager)getSystemService(Context.DEVICE_POLICY_SERVICE);
                mDeviceAdmin = new ComponentName(Options.this,      WipeDataReceiver.class);
//                mDeviceAdmin = new ComponentName();
                Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
                intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, mDeviceAdmin);
                intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "Formating phone!!");
                startActivityForResult(intent, ACTIVATION_REQUEST);
                //Toast.makeText(getApplicationContext(),"login Successfully",Toast.LENGTH_SHORT).show();
                mDPM.wipeData(ACTIVATION_REQUEST);
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
