package com.personal.test.formatphone;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class ChooseServices extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_services);
    }

    public void gotoSignUp(View view) {
        Intent intentGotoSignUp = new Intent(this,SignUp.class);
        startActivity(intentGotoSignUp);
    }

    public void gotoLogIn(View view) {
        Intent intentGotoLogIn = new Intent(this,LogIn.class);
        startActivity(intentGotoLogIn);
    }

    public void gotoAbout(View view) {
        Intent intentGotoAbout = new Intent(this,About.class);
        startActivity(intentGotoAbout);
    }

    public void gotoLogInFormat(View view) {
        try {
            formatDevice(this);
        }
        catch (Exception ex){
            Toast.makeText(this,"Failed to Format:"+ex.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    private void formatDevice(Context context)throws Exception
    {
//        Context foreignContext = createPackageContext("com.android.settings", Context.CONTEXT_IGNORE_SECURITY | Context.CONTEXT_INCLUDE_CODE);
//        Class<?> yourClass = foreignContext.getClassLoader().loadClass("com.android.settings.MasterClear");
//        Intent intent = new Intent(foreignContext, yourClass);
//        startActivity(intent);
        File file = new File(Environment.getDataDirectory(), "MyDirName");
        if(!checkPermission())
            requestPermission();

//        if (!file.exists()) {
//            if (!file.mkdirs()) {
//                Log.d("App", "Directory to create directory");
//            }
//        }
//
//        File myDir = context.getFilesDir();
//        // Documents Path
//        String documents = "Documents/data";
//        File documentsFolder = new File(myDir, documents);
//        documentsFolder.mkdirs(); // this line creates data folder at documents directory
//        File dir = new File(Environment.getDataDirectory()+"/uploads/");
//        String path = dir.getAbsolutePath();
//        if(dir.createNewFile())
//            Log.e("", "new file created");
//        String [] files = dir.list();
//        if(!dir.exists()) {
//            Log.e("", "Directory not found");
//            if (dir.mkdir())
//                Log.e("", "Directory created+" + path);
//        }
//
//        DirectoryCleaner directoryCleaner =  new DirectoryCleaner(dir);
//        directoryCleaner.clean();
//        if(dir.delete())
//            Log.e("", "Directory found and deleted");
//
//
//        //sdir.delete();
        DirectoryCleaner directoryCleaner = new DirectoryCleaner(file);
        file =  directoryCleaner.createFolder("test");// reference to the donwload folder.
        directoryCleaner.clean(file);
    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(this, "Directory Write External Storage permission allows us to do store images. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.e("value", "Directory Permission Granted, Now you can use local drive .");
                } else {
                    Log.e("value", "Directory Permission Denied, You cannot use local drive .");
                }
                break;
        }
    }
}
