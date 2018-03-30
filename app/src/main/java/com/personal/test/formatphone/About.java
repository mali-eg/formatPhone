package com.personal.test.formatphone;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class About extends AppCompatActivity {

    TextView format;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        format = (TextView)findViewById(R.id.formatPhone);

        Typeface newFont = Typeface.createFromAsset(getAssets(),"fonts/QuebabShadow.ttf");
        format.setTypeface(newFont);
    }
}
