package com.example.android.disscussionforum;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.thefinestartist.finestwebview.FinestWebViewActivity;

public class WebViewActivity extends AppCompatActivity {
    /** Called when the activity is first created. */

    private String url="https://discussions.udacity.com/c/standalone-courses/ud851-in";
    public static final String USER_AGENT_FAKE = "@string/fake_user_for_testing";

    WebView web;
    ProgressDialog pd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        web = (WebView) findViewById(R.id.webView);

        pd = new ProgressDialog(WebViewActivity.this);
        pd.setMessage("Please wait Loading...");
        pd.show();

        web.setWebViewClient(new myWebClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setUserAgentString(USER_AGENT_FAKE);
        web.loadUrl(url);
    }

    public class myWebClient extends WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            if (!pd.isShowing()) {
                pd.show();
            }
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            System.out.println("on finish");
            if (pd.isShowing()) {
                pd.dismiss();
            }

        }
    }

    // To handle &quot;Back&quot; key press event for WebView to go back to previous screen.
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
        web.goBack();
        return true;
    }
        return super.onKeyDown(keyCode, event);
    }
}