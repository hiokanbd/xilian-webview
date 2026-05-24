package com.xilian.webview;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView webView = new WebView(this);
        setContentView(webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setSupportZoom(false);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode,
                    String description, String failingUrl) {
                view.loadData(
                    "<html><body style='background:#FFF5F8;display:flex;align-items:center;justify-content:center;height:100vh;font-family:sans-serif;color:#5E4B66;text-align:center'><div>昔涟还没醒来呢…<br><small>请在 Termux 里输入「昔涟」启动</small></div></body></html>",
                    "text/html", "UTF-8"
                );
            }
        });

        webView.loadUrl("http://127.0.0.1:8000");
    }

    @Override
    public void onBackPressed() {
        WebView webView = (WebView) getWindow().getDecorView().findViewById(android.R.id.content);
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
