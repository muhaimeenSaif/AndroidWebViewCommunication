package com.example.muhaimeen.webviewcommunication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WebView webView = new WebView(MainActivity.this);
        webView.getSettings().setJavaScriptEnabled(true);
        // Add your local url here//
        webView.loadUrl("http://192.168.0.147/messaging/deliverBae/WebViewTest.html"); //not in scope of this gist
        webView.setWebViewClient(new WebViewClient(){
            public void onPageFinished(WebView view, String url){
                //Here you want to use .loadUrl again
                //on the webview object and pass in
                //"javascript:<your javaScript function"
                webView.loadUrl("javascript:myJavaScriptFunc('argumentPassingIn')"); //if passing in an object. Mapping may need to take place
            }
        });
        webView.addJavascriptInterface(new JavaScriptInterface(this), "Android");
        setContentView(webView);


    }

}
