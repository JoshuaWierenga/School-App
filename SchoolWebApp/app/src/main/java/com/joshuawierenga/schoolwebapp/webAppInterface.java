package com.joshuawierenga.schoolwebapp;

import android.content.Context;
import android.webkit.JavascriptInterface;

public class webAppInterface {
    public Context mContext;

    webAppInterface(Context c) {
        mContext = c;
    }

    @JavascriptInterface
    public void pageStatus(boolean status) {
        webHelpers.pagestatus = status;
    }
}
