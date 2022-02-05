package com.example.demob12lesson7.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import com.example.demob12lesson7.R;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        initViews();

    }

    private void initViews() {
        WebView webView = findViewById(R.id.web_view);
        String url = getIntent().getStringExtra("url");
        Log.d("@@@@@@@@@@", "url: "+url);
        webView.loadUrl(url);
    }

}