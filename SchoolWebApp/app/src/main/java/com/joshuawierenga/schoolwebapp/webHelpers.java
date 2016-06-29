package com.joshuawierenga.schoolwebapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.webkit.WebView;

public class webHelpers {
    public static boolean pagestatus;

    public boolean isNetworkAvalable(WebView view) {
        ConnectivityManager connectivityManager = (ConnectivityManager) view.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    public boolean isPageAvalable(WebView view) {
        view.loadUrl("javascript:var offlinestatus = document.getElementsByClassName('navbar-header').length > 0; Android.pageStatus(offlinestatus)");
        return pagestatus;
    }
}
