package com.example.demob12lesson7.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.demob12lesson7.R;
import com.google.android.material.textfield.TextInputLayout;

public class RegistrationActivity extends AppCompatActivity {

    private TextInputLayout textInputEmail;
    private TextInputLayout textInputUsername;
    private TextInputLayout textInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        initViews();

    }

    private void initViews() {
        textInputEmail = findViewById(R.id.text_input_email);
        textInputPassword = findViewById(R.id.text_input_password);
        textInputUsername = findViewById(R.id.text_input_username);
    }

    private boolean validateEmail() {
        String inputEmail = textInputEmail.getEditText().getText().toString().trim();

        if (inputEmail.isEmpty()) {
            textInputEmail.setError("Field can`t be empty");
            return false;
        } else {
            textInputEmail.setError(null);
            //textInputEmail.setErrorEnabled(false);
            return true;
        }
    }


    private boolean validateUsername() {
        String inputUsername = textInputUsername.getEditText().getText().toString().trim();

        if (inputUsername.isEmpty()) {
            textInputUsername.setError("Field can`t be empty");
            return false;
        } else if (inputUsername.length() > 15) {
            textInputUsername.setError("Username too long");
            return false;
        } else {
            textInputUsername.setError(null);
            return true;
        }
    }


    private boolean validatePassword() {
        String inputPassword = textInputPassword.getEditText().getText().toString().trim();

        if (inputPassword.isEmpty()) {
            textInputPassword.setError("Field can`t be empty");
            return false;
        } else {
            textInputPassword.setError(null);
            return true;
        }
    }


    public void confirmInput(View v) {
        if (!validateEmail() || !validatePassword() || !validateUsername()) {
            return;
        }

        String input = "Email: " + textInputEmail.getEditText().getText().toString();
        input += "\n";
        input += "Username: " + textInputUsername.getEditText().getText().toString();
        input += "\n";
        input += "Password: " + textInputPassword.getEditText().getText().toString();

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }

}