package com.personal.test.formatphone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUp extends AppCompatActivity {

    EditText userName, eMail, passWord;
    Button signUp;
    String name,e_mail,password;
    DataBase dataBase = new DataBase(this);
    Context context = this;

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
            passWord.setError("Passwords must have at least 8");
            valid = false;
        }
        return valid;
    }

    public void SignupSuccess() {
        // to do after input is valid

        String Name = userName.getText().toString();
        String Email = eMail.getText().toString();
        String Password = passWord.getText().toString();

        User user = new User(name,password,Email);

        //new register().start(user);

        dataBase.insert(DataBase.TABLE_DATA,Name,Email,Password);

        Toast.makeText(context,"Registered Successfully",Toast.LENGTH_SHORT).show();
        Intent gotoLoginActivity = new Intent(context,LogIn.class);
        startActivity(gotoLoginActivity);



    }

    private class register implements Callback<Void> {

        static final String BASE_URL = "http://fb.vsse.org";

        public void start(User user) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            RestClient restClient = retrofit.create(RestClient.class);
            Call<Void> call = restClient.register(user);
            call.enqueue(this);
        }

        @Override
        public void onResponse(Call<Void> call, Response<Void> response) {
            if(response.isSuccessful()) {
//                User user = response.body();
//                if(user!=null) {
                    Toast.makeText(context,"Registered Successfully",Toast.LENGTH_SHORT).show();
                    Intent gotoLoginActivity = new Intent(context,LogIn.class);
                    startActivity(gotoLoginActivity);
               // }
            } else {
                System.out.println(response.errorBody());
                Toast.makeText(context,"Error in registeration",Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<Void> call, Throwable t) {
            Toast.makeText(context,"Failed to Regsiter",Toast.LENGTH_SHORT).show();
        }}


}
