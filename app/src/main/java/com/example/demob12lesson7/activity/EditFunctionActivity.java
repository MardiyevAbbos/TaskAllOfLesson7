package com.example.demob12lesson7.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.demob12lesson7.R;

public class EditFunctionActivity extends AppCompatActivity {

    // two editText fields
    private EditText edtEmail, edtPassword;
    // two textView fields
    private TextView txtEmail, txtPassword;
    // one login Button
    private Button btnLogin;

    // implement the TextWatcher callback listener
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // get the content of both edit text
            String emailInput = edtEmail.getText().toString();
            String passwordInput = edtPassword.getText().toString();

            // check whether both the fields are empty or not
            btnLogin.setEnabled(!emailInput.isEmpty() && !passwordInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_function);

        initViews();

        edtEmailKeyListener();

        edtPasswordKeyListener();

    }

    private void initViews() {
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.loginButton);

        edtEmail.addTextChangedListener(textWatcher);
        edtPassword.addTextChangedListener(textWatcher);
    }


    private void edtEmailKeyListener(){
        edtEmail.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // String res = edtEmail.getText().toString();  // this is for onTextChanged

                if (event.getAction() == KeyEvent.ACTION_DOWN){
                    if (keyCode == KeyEvent.KEYCODE_ENTER || keyCode == KeyEvent.KEYCODE_DPAD_CENTER){
                        String res = edtEmail.getText().toString();  // this is for onClick enter Button
                        txtEmail.setText(res);
                    }
                }
                return false;
            }
        });
    }


    private void edtPasswordKeyListener(){
        edtPassword.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN){
                    if (keyCode == KeyEvent.KEYCODE_ENTER || keyCode == KeyEvent.KEYCODE_DPAD_CENTER){
                        String res = edtPassword.getText().toString();
                        txtPassword.setText(res);
                    }
                }
                return false;
            }
        });
    }


}