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
    void pageCheck(String page) {
        webHelpers.currentpage = page;
        Log.e("webAppInterface", "pageStatus: JSNewPage: " + page);
    }
}