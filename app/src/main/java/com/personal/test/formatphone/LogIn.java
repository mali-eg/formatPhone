package com.personal.test.formatphone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    EditText eMail, passWord;
    Button loginbt;
    String e_mail, password;
    DataBase dataBase = new DataBase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        eMail = (EditText) findViewById(R.id.emailLogin);
        passWord = (EditText) findViewById(R.id.passLogin);
        loginbt = (Button) findViewById(R.id.login);

        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
    }

    public void Register() {
        initialize(); // initial input with string variables
        if (!Validate()) {
            Toast.makeText(this, "Login has failed", Toast.LENGTH_SHORT).show();
        } else {
            LiginSuccess();
        }
    }

    public void initialize() {
        e_mail = eMail.getText().toString().trim();
        password = passWord.getText().toString().trim();
    }

    public boolean Validate() {
        boolean valid = true;
        if (e_mail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(e_mail).matches()) {
            eMail.setError("please set valid email address");
            valid = false;
        }
        if (password.isEmpty() || password.length() > 8) {
            passWord.setError("please set valid password");
            valid = false;
        }
        return valid;
    }

    public void LiginSuccess() {
        // to do after input is valid
        String email = eMail.getText().toString();
        String pass = passWord.getText().toString();
        String password = dataBase.verifyAccount(email);
        if (pass.equals(password)) {
            Intent gotoLoginActivity = new Intent(this, Options.class);
            startActivity(gotoLoginActivity);
        } else {
            Toast.makeText(this, "error password please try again", Toast.LENGTH_SHORT).show();
            passWord.setText("");
            passWord.findFocus();
        }
    }


}
