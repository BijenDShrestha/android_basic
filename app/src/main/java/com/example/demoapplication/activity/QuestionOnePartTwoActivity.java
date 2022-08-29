package com.example.demoapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.demoapplication.R;

public class QuestionOnePartTwoActivity extends AppCompatActivity {

    private TextView editFirstName;
    private TextView editLastName;
    private TextView editUsername;
    private TextView editEmail;
    private TextView editContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one_part_two);

        findViews();
    }

    private void findViews(){

        editFirstName = findViewById(R.id.textViewFirstName);
        String firstname = getIntent().getStringExtra("firstname");
        editFirstName.setText(firstname);

        editLastName = findViewById(R.id.textViewLastName);
        String lastname = getIntent().getStringExtra("lastname");
        editLastName.setText(lastname);

        editUsername = findViewById(R.id.textViewUsername);
        editUsername.setText(getIntent().getStringExtra("username"));

        editEmail = findViewById(R.id.textViewEmail);
        editEmail.setText(getIntent().getStringExtra("email"));

        editContact = findViewById(R.id.textViewContact);
        editContact.setText(getIntent().getStringExtra("contact"));


    }
}