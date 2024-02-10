package com.example.summerprelab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SigupActivity extends AppCompatActivity {

    EditText username, password;
    Button submit_btn;
    Button login_btn;
    String usernameInput, passwordInput;
    SharedPreferences storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        storage=getSharedPreferences("myAppStorage", MODE_PRIVATE);
        username=findViewById(R.id.et_username);
        password=findViewById(R.id.et_password);
        submit_btn=findViewById(R.id.bt_sign_up);
        login_btn=findViewById(R.id.bt_back);
        Log.d("username", storage.getString("username", "error"));
        Log.d("password", storage.getString("password", "error"));
        SharedPreferences.Editor edit = storage.edit();

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameInput=username.getText().toString();
                passwordInput=password.getText().toString();
                Log.d("You have signed up!", "onClick: ");
                edit.putString("username", usernameInput);
                edit.putString("password", passwordInput);
                edit.apply();
                edit.commit(); //storing data into shared preference
                Toast.makeText(SigupActivity.this, "Registration completed!", Toast.LENGTH_SHORT).show();
                finish();
//                commit via btn

            }
        });
    }
}