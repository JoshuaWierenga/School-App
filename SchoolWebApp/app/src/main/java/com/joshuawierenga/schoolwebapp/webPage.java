package com.joshuawierenga.schoolwebapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class webPage extends AppCompatActivity {
    webHelpers webhelpers = new webHelpers();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webpage);

        WebView webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new customWebClient());
        webView.addJavascriptInterface(new webAppInterface(this), "Android");
        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
        webSettings.setAllowFileAccess(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);

        if (!webhelpers.isNetworkAvalable(webView)) {
            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }

        webView.loadUrl("https://newtownhighschooltas.org/");
    }
}