package com.example.matan.matan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        WebView webView;
        webView = (WebView) findViewById(R.id.webview);
        webView.loadUrl("file:///android_asset/page_1.html");
        webView.setWebViewClient(new WebViewClient());

    }
}
