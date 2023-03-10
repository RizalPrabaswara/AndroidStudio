package com.example.mywebview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x=(WebView)findViewById(R.id.webView1);
        x.setWebViewClient(new WebViewClient());
        //x.loadUrl("https://www.google.com/");
        x.loadUrl("http://192.168.100.7/dashboard/");
        WebSettings y = x.getSettings();
        y.setJavaScriptEnabled(true);
    }
    public void onBackPressed()
    {
        if(x.canGoBack()){
            x.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}