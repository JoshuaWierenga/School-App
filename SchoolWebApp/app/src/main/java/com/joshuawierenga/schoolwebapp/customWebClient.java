package com.joshuawierenga.schoolwebapp;

import android.content.Intent;
import android.net.Uri;
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
            String toasttext;
            if (webhelpers.isPageAvalable(view)) {
                //view.loadUrl("javascript:var offline = document.getElementsByClassName('navbar-header')[0].innerHTML += \"<p style=\\\"text-align:justify;\\\"><strong>Internet Lost: Showing Offline Version</strong></p>\"");
                toasttext = "Showing Offline Version";
            }
            else {
                toasttext = "No Offline Copy";
            }
            Toast toast = Toast.makeText(view.getContext(), "Internet Lost: " + toasttext, Toast.LENGTH_LONG);
            toast.show();
        }
    }
}