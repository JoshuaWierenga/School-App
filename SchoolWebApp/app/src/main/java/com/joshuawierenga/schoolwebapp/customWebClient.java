package com.joshuawierenga.schoolwebapp;

import android.content.Intent;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class customWebClient extends WebViewClient {

    public static boolean pagestatus = true;

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
        view.loadUrl("javascript:pageStatus(document.getElementsByClassName('navbar-header').count > 0)");
        if (!web.network && pagestatus) {
            view.loadUrl("javascript:var offline = document.getElementsByClassName('navbar-header')[0].innerHTML += \"<p style=\\\"text-align:justify;\\\"><strong>Internet Lost: Showing Offline Version</strong></p>\"");
            Toast toast = Toast.makeText(view.getContext(), "Internet Lost: Showing Offline Version", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    @JavascriptInterface
    public void pageStatus(boolean status) {
        pagestatus = status;
    }
}
