package com.example.myapplication.Login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.R;

public class SignupActivity extends AppCompatActivity {

    private EditText editUserName;
    private EditText editPassword;
    private EditText editPassCom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        editUserName = findViewById(R.id.Signup_Username);
        editPassword = findViewById(R.id.Signup_Password);
        editPassCom = findViewById(R.id.Signup_VaPassword);
    }


    public void singUp(View view) {

    }


}