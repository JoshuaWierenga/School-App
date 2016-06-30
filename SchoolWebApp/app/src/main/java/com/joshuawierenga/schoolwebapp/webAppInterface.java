package com.joshuawierenga.schoolwebapp;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;

public class webAppInterface {
    public Context mContext;

    webAppInterface(Context c) {
        mContext = c;
    }

    @JavascriptInterface
    public void pageStatus(String page) {
        webHelpers.pagestatus = page == "data:text/html,chromewebdata";
    }
}
