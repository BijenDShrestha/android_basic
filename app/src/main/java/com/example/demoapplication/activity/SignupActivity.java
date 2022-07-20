package com.example.demoapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.demoapplication.R;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private TextView editFirstName;
    private TextView editLastName;
    private TextView editUsername;
    private RadioGroup radioGender;
    private RadioButton gender;
    private TextView editEmail;
    private TextView editContact;
    private TextView editPassword;
    private TextView editConfirmPassword;
    private AppCompatButton createAccountButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sign_up);
        initToolbar();
        findViews();
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.sign_up);

        //for back button in toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowTitleEnabled(true);
    }

    //for action for back button in toolbar
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void findViews(){
        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editUsername = findViewById(R.id.editSignUpUsername);

//        radioGender = findViewById(R.id.radio_gender);
//        int selectId = radioGender.getCheckedRadioButtonId();
//        gender = findViewById(selectId);

        editEmail = findViewById(R.id.editEmail);
        editContact = findViewById(R.id.editContact);
        editPassword = findViewById(R.id.editSignUpPassword);
        editConfirmPassword = findViewById(R.id.editConfirmPassword);

        createAccountButton = findViewById(R.id.create_account_button);

        createAccountButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.create_account_button) {
            if (validateDetail()) {

                String username = editUsername.getText().toString();
                Log.d("Data FirstName", editFirstName.getText().toString());
                Log.d("Data LastName", editLastName.getText().toString());
                Log.d("Data Username", username);
//                Log.d("Data Gender", gender.getText().toString());


                Log.d("Data Email", editEmail.getText().toString());
                Log.d("Data Contact", editContact.getText().toString());
                Log.d("Data Password", editPassword.getText().toString());
                Log.d("Data", "Successfully Created");

                Intent intent = new Intent(SignupActivity.this, DashboardActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }

        }

    }

    private boolean validateDetail() {
        if (editFirstName.length() == 0) {
            Log.e("Error", "FirstName is empty");
            editFirstName.setError("This field is required");
            return false;
        }
        if (editLastName.length() == 0) {
            Log.e("Error", "LastName is empty");
            editLastName.setError("This field is required");
            return false;
        }

        if (editUsername.length() == 0) {
            Log.e("Error", "Username is empty");
            editLastName.setError("This field is required");
            return false;
        }

//        int genderId = radioGender.getCheckedRadioButtonId();
//        if (genderId == -1) {
//            Log.e("Error", "Gender not selected");
//        }

        if (editEmail.length() == 0) {
            Log.e("Error", "Email is empty");
            editEmail.setError("This field is required");
            return false;
        }
        if (editContact.length() == 0) {
            Log.e("Error", "Contact is empty");
            editContact.setError("This field is required");
            return false;
        }
        if (editPassword.length() == 0) {
            Log.e("Error", "Password is empty");
            editPassword.setError("This field is required");
            return false;
        }
        if (editConfirmPassword.length() == 0) {
            Log.e("Error", "Confirm Password is empty");
            editConfirmPassword.setError("This field is required");
            return false;
        }

        if(!editPassword.getText().toString().equals(editConfirmPassword.getText().toString())) {
            Log.e("Error", "Password not match");
            editConfirmPassword.setError("Password not match");
            return false;
        }

        return true;

    }
}