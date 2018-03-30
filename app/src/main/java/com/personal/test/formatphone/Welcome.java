package com.personal.test.formatphone;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    TextView welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //font
        welcome = (TextView) findViewById(R.id.Welcometxt);

        Typeface newfont = Typeface.createFromAsset(getAssets(), "fonts/QuebabShadow.ttf");
        welcome.setTypeface(newfont);


        final Intent intentToChooseServices = new Intent(this,ChooseServices.class);

        //go to next activity after 3m
        Thread mythread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(intentToChooseServices);
                    finish();
                }
            }
        };
        mythread.start();
    }
}
