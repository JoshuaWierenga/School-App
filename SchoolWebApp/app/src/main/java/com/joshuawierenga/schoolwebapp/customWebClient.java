package com.joshuawierenga.schoolwebapp;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class customWebClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        String site = Uri.parse(url).getHost();
        if (site.equals("newtownhighschooltas.org") || site.equals("newtownhighschooltasmania.wordpress.com")) {
            return false;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }
}
