package com.example.tbstest;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = findViewById(R.id.sdk_webview);
        init();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void init() {
        String url = "http://h5.shumensy.com/rakshasa-street";
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setDisplayZoomControls(false);
        mWebView.getSettings().setBlockNetworkLoads(false);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mWebView.setWebViewClient(new MyWebViewClient());
        mWebView.loadUrl(url);
    }

    public class MyWebViewClient extends WebViewClient{
        @Override
        public void onPageFinished(WebView webView, String s) {
            super.onPageFinished(webView, s);
            imageReset();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String s) {
//            return super.shouldOverrideUrlLoading(webView, s);
            if (s.startsWith("fq-smgfsq-jsbridge")){
                return true;
            }
            return false;
        }
    }



    private void imageReset() {
        mWebView.loadUrl("javascript:(function(){" +
                "var objs = document.getElementsByTagName('img'); " +
                "for(var i=0;i<objs.length;i++)  " +
                "{"
                + "var img = objs[i];   " +
                "    img.style.maxWidth = '100%'; img.style.height = 'auto';  " +
                "}" +
                "})()");
    }
}
