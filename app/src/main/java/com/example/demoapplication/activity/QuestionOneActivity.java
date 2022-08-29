package com.example.demoapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.demoapplication.R;

public class QuestionOneActivity extends AppCompatActivity {

    private TextView editFirstName;
    private TextView editLastName;
    private TextView editUsername;
    private TextView editEmail;
    private TextView editContact;
    private AppCompatButton createAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);
        findViews();
    }

    private void findViews(){
        editFirstName = findViewById(R.id.editFirstNameQ1);
        editLastName = findViewById(R.id.editLastNameQ1);
        editUsername = findViewById(R.id.editSignUpUsernameQ1);

        editEmail = findViewById(R.id.editEmailQ1);
        editContact = findViewById(R.id.editContactQ1);

        createAccountButton = findViewById(R.id.create_q1_button);

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.create_q1_button) {
                    if (validateDetail()) {

                        Intent intent = new Intent(QuestionOneActivity.this, QuestionOnePartTwoActivity.class);
                        intent.putExtra("firstname", editFirstName.getText().toString());
                        intent.putExtra("lastname", editLastName.getText().toString());
                        intent.putExtra("username", editUsername.getText().toString());
                        intent.putExtra("email", editEmail.getText().toString());
                        intent.putExtra("contact", editContact.getText().toString());
                        startActivity(intent);
                    }
                }
            }
        });

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

        return true;

    }
}