package com.personal.test.formatphone;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class GetPhotos extends AppCompatActivity {

    ImageView photo;
    Button deletebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_photos);

        photo = (ImageView)findViewById(R.id.gallaryPhoto);
        deletebtn = (Button)findViewById(R.id.deletePhotobtn);

    }

    public void getPhoto(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(intent,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100 && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            photo.setImageURI(uri);
        }
    }



}
