package com.joshuawierenga.schoolwebapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;
import android.webkit.WebView;

public class webHelpers {
    public static boolean pagestatus;

    public boolean isNetworkAvalable(WebView view) {
        ConnectivityManager connectivityManager = (ConnectivityManager) view.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    public boolean isPageAvalable(WebView view) {
        Log.i("webAppInterface", "Pre Page Status: " + view.getTitle());
        view.loadUrl("javascript:Android.pageStatus(window.location.href)");
        return pagestatus;
    }
}
