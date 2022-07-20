package com.example.demoapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demoapplication.R;

public class LoginActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText editUsername, editPassword;
    private CheckBox checkRemember, checkDoNotRemember;
    private AppCompatButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        initToolbar();
        findViews();

        //TextView action to shift to sign up form
        //Works in button too
        TextView textView = (TextView) findViewById(R.id.signUp);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initToolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.welcome);

        //for back button in toolbar
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowTitleEnabled(true);

    }

    private void findViews(){
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        checkRemember = findViewById(R.id.checkRemember);
        //Individual check or uncheck
//        checkRemember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//            }
//        });


//        checkDoNotRemember = findViewById(R.id.checkDoNotRemember);

        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.loginButton) {
                    // d = debug
                    // e = error
//                    Log.d("Data Username", editUsername.getText().toString());
//                    Log.d("Date Password", editPassword.getText().toString());
//                    OR
                    Log.d("Data", editUsername.getText().toString() + " " + editPassword.getText().toString());
                    String remember = " ";
                    if(checkRemember.isChecked()) {
                        remember = remember + " " + checkRemember.getText().toString();
                    }
//                    if (checkDoNotRemember.isChecked()){
//                        remember = remember + " " + checkDoNotRemember.getText().toString();
//                    }
                    Log.d("Data", remember);

                    String username = editUsername.getText().toString();
                    String password = editPassword.getText().toString();

                    if(!username.isEmpty() && !password.isEmpty()) {
                        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                        intent.putExtra("username", username);
//                        intent.putExtra("password", password);
//                        intent.putExtra("userId", 101);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Username and Password cannot be empty", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


    }

}