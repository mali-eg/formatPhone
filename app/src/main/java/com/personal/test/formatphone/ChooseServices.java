package com.personal.test.formatphone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChooseServices extends AppCompatActivity {

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
        Intent intentGotoLogInFormat = new Intent(this,LogIn.class);
        startActivity(intentGotoLogInFormat);
    }
}
