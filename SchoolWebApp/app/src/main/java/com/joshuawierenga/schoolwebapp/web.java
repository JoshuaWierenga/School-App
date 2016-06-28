package com.joshuawierenga.schoolwebapp;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class web extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        WebView webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new customWebClient());

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
        webSettings.setAllowFileAccess(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);

        if (!isNetworkAvalable()) {
            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            //String offlinetext = "<html><body>Internet Lost: Showing Offline Version</body></html>";
            webView.loadUrl("javascript:function offline() {var div = Document.getElementsByClassName('navbar-header')[0], div:innerHTML += \"<p style=\"text-align:justify;\"><strong>Internet Lost: Showing Offline Version</strong></p>\"} offline()");


        }

        webView.loadUrl("https://newtownhighschooltas.org/");

    }

    private boolean isNetworkAvalable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}