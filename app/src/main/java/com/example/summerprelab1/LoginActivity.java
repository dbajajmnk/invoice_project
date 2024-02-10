package com.example.summerprelab1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button login_btn;
    Button signup_btn;
    String usernameInput, passwordInput;
    SharedPreferences storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        storage=getSharedPreferences("myAppStorage", MODE_PRIVATE);
        username=findViewById(R.id.et_uname);
        password=findViewById(R.id.et_pwd);
        login_btn=findViewById(R.id.bt_signin);
        signup_btn=findViewById(R.id.bt_signup);
        Log.d("username", storage.getString("username", "error"));
        Log.d("password", storage.getString("password", "error"));
//        SharedPreferences.Editor edit = storage.edit();

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj=new Intent("act.signup");
                startActivity(obj);
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameInput=username.getText().toString();
                passwordInput=password.getText().toString();
                if(usernameInput.equals(storage.getString("username", "")) && passwordInput.equals(storage.getString("password", ""))){
                    Toast.makeText(getApplicationContext(),"Login successful!", Toast.LENGTH_SHORT).show();
                    Intent obj=new Intent("act.dashboard");
                    startActivity(obj);
                }
                //getApplicationContext()=> returns the current execution of the obj
                else{
                    Toast.makeText(LoginActivity.this, "Invalid username and password", Toast.LENGTH_SHORT).show();
                }
//                Log.d("You have signed up!", "onClick: ");
//                edit.putString("username", usernameInput);
//                edit.putString("password", passwordInput);
//                edit.apply();
//                edit.commit(); //storing data into shared preference
//                commit via btn

            }
        });
    }
}