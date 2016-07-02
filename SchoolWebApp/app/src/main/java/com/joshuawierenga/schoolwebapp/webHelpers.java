package com.joshuawierenga.schoolwebapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;
import android.webkit.WebView;

public class webHelpers {
    public static String currentpage;

    public boolean isNetworkAvalable(WebView view) {
        ConnectivityManager connectivityManager = (ConnectivityManager) view.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    public boolean isPageAvailable(WebView view) {
        currentpage = "";
        view.loadUrl("javascript:Android.pageCheck(window.location.href)");
        //int i = 0;
        //while (currentpage.isEmpty() && i != 500000) i++;
        int i = 0;
        while (currentpage.isEmpty()) {
            try {
                if (i % 10 == 0) view.loadUrl("javascript:Android.pageCheck(window.location.href)");
                Thread.sleep(500);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Log.e("webHelpers", "isPageAvailable: " + currentpage);
        return currentpage.equals("data:text/html,chromewebdata");
    }

}
