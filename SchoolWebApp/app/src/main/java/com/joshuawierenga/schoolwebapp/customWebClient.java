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
        if (site.equals("newtownhighschooltas.org") || site.equals("newtownhighschooltasmania.wordpress.com")) {
            return false;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }

    public void onPageFinished(WebView view, String url) {
        if (!webhelpers.isNetworkAvalable(view)) {
            String toasttext = "No Offline Copy";
            boolean page = !webhelpers.isPageAvalable(view);
            Log.i("webAppInterface", "First Page Status: " + page);
            if (page) {
                Log.i("webAppInterface", "Offline Page Status: " + page);
                toasttext = "Showing Offline Version";
            }
            Log.i("webAppInterface", "Second Page Status: " + page);
            Toast toast = Toast.makeText(view.getContext(), "Internet Lost: " + toasttext, Toast.LENGTH_LONG);
            toast.show();
            Log.i("webAppInterface", "Third Page Status: " + page);
        }
    }
}