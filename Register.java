package com.example.timelymobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    DatabaseHelper timely;
    TextView loginLink;
    EditText etFirstName;
    EditText etLastName;
    EditText etEmail;
    EditText etPassword;
    EditText etConfirmPass;
    Button signupBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        timely = new DatabaseHelper(this);
        loginLink = findViewById(R.id.loginLink);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etEmail = findViewById(R.id.etSignUpEmail);
        etPassword = findViewById(R.id.etSignUpPass);
        etConfirmPass = findViewById(R.id.etConfirmPass);
        signupBtn = findViewById(R.id.signupBtn);





        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });



    }

    public void addData(View view){
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String firstName = etFirstName.getText().toString();
                final String lastName = etLastName.getText().toString();
                final String email = etEmail.getText().toString();
                final String password = etPassword.getText().toString();
                final String confirmPassword = etConfirmPass.getText().toString();

                boolean insertData = false;


                if ((password.equals(confirmPassword))) {
                    insertData = timely.addData(firstName, lastName, email, password);
                } else {
                    Toast.makeText(Register.this, "Passwords do not match.", Toast.LENGTH_LONG).show();
                }


                if (insertData == true) {
                    Toast.makeText(Register.this, "Successfully Registered", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(Register.this, "Registration unsuccessful", Toast.LENGTH_LONG).show();
                }

            }

        });

    }







}
