package com.personal.test.formatphone;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class Options extends AppCompatActivity {

    Button deletePhoto, takePhoto;
    private final int REQUEST_CODE_CAMERA_IMAGE = 1000;
    private final int REQUEST_CODE_EXTERNAL_IMAGE = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);


//        deletePhoto = (Button)findViewById(R.id.deletePhotobtn);
//        takePhoto = (Button)findViewById(R.id.takePhotobtn);
////select picture from external storage
//        deletePhoto.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                // choose picture from gallery
//                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//
//                startActivityForResult(intent,
//                        REQUEST_CODE_EXTERNAL_IMAGE);
//
//            }
//        });
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
