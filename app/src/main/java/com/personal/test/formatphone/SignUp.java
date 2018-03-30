package com.personal.test.formatphone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText userName, eMail, passWord;
    Button signUp;
    String name,e_mail,password;
    DataBase dataBase = new DataBase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userName = (EditText) findViewById(R.id.username);
        eMail = (EditText) findViewById(R.id.email);
        passWord = (EditText) findViewById(R.id.pass);
        signUp = (Button) findViewById(R.id.signup);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register(); // call when the button is clicked with valid input
            }
        });
    }


    public void Register() {
        initialize(); // initial input with string variables
        if (!Validate()) {
            Toast.makeText(this, "Sign up has failed", Toast.LENGTH_SHORT).show();
        } else {
            SignupSuccess();
        }
    }

    public void initialize() {
        name = userName.getText().toString().trim();
        e_mail = eMail.getText().toString().trim();
        password = passWord.getText().toString().trim();
    }

    public boolean Validate() {
        boolean valid=true;
        if (name.isEmpty() || name.length()>32)
        {
            userName.setError("please set valid user name");
            valid = false;
        }
        if (e_mail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(e_mail).matches())
        {
            eMail.setError("please set valid email address");
            valid = false;
        }
        if (password.isEmpty() || password.length()>8)
        {
            passWord.setError("please set valid password");
            valid = false;
        }
        return valid;
    }

    public void SignupSuccess() {
        // to do after input is valid

        String Name = userName.getText().toString();
        String Email = eMail.getText().toString();
        String Password = passWord.getText().toString();

        dataBase.insert(DataBase.TABLE_DATA,Name,Email,Password);

        Intent gotoLoginActivity = new Intent(this,LogIn.class);
        startActivity(gotoLoginActivity);

    }

}
