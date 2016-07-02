package com.joshuawierenga.schoolwebapp;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class customWebClient extends WebViewClient {
    webHelpers webhelpers = new webHelpers();

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        String site = Uri.parse(url).getHost();
        if (site.equals("newtownhighschooltas.org") || site.equals("newtownhighschooltasmania.wordpress.com")) return false;
        view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        return true;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        if (!webhelpers.isNetworkAvalable(view)) {
            String toasttext = "No Offline Copy";
            Boolean page = webhelpers.isPageAvailable(view);
            Log.e("customWebClient", "onPageFinished: URL: " + view.getUrl());
            Log.e("customWebClient", "onPageFinished: REAL_URL: " + webHelpers.currentpage);
            if (!page) {
                toasttext = "Showing Offline Version";
            }
            Toast toast = Toast.makeText(view.getContext(), "Internet Lost: " + toasttext, Toast.LENGTH_LONG);
            toast.show();
        }
    }
}