package com.example.demob12lesson7.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demob12lesson7.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {
        Button btnOpenShapeUI = findViewById(R.id.open_shapeUI);
        Button btnOpenRegistration = findViewById(R.id.open_registration);
        Button btnOpenTextWatcher = findViewById(R.id.open_textWatcher);
        Button btnOpenPagerRV = findViewById(R.id.open_pagerRV);
        Button btnOpenHashtag = findViewById(R.id.open_hashtag);

        btnOpenShapeUI.setOnClickListener(this);

        btnOpenRegistration.setOnClickListener(this);

        btnOpenTextWatcher.setOnClickListener(this);

        btnOpenPagerRV.setOnClickListener(this);

        btnOpenHashtag.setOnClickListener(this);
    }


    private void openShapeUIActivity() {
        Intent intent = new Intent(this, ShapeUIActivity.class);
        startActivity(intent);
    }


    private void openRegistrationActivity() {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }


    private void openEditFunctionActivity() {
        Intent intent = new Intent(this, EditFunctionActivity.class);
        startActivity(intent);
    }


    private void openPagerRVActivity() {
        Intent intent = new Intent(this, PagerUIActivity.class);
        startActivity(intent);
    }


    private void openHashtagActivity() {
        Intent intent = new Intent(this, HashtagActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.open_shapeUI:
                openShapeUIActivity();
                break;
            case R.id.open_registration:
                openRegistrationActivity();
                break;
            case R.id.open_textWatcher:
                openEditFunctionActivity();
                break;
            case R.id.open_pagerRV:
                openPagerRVActivity();
                break;
            case R.id.open_hashtag:
                openHashtagActivity();
        }
    }

}