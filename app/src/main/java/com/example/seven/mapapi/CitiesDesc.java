package com.example.seven.mapapi;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;

public class CitiesDesc extends AppCompatActivity {

    Context context;
    WebView webview;
    String fid = "";

    @Override
    public void onBackPressed() {
        this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cities_desc);

        String[] asset_files = {
                "Benc.html",
                "Gusmar.html",
                "Kuc.html",
                "Corraj.html",
                "Borsh.html",
                "Nivice.html",
                "Doshnice.html",
                "Dragot.html",
                "Fushebardhe.html",
                "Golem.html",
                "Hoshteve.html",
                "Kaparjel.html",
                "Koncke.html",
                "Kudhes.html",
                "Lekdush.html",
                "Leskaj.html",
                "Nivan.html",
                "Peshtan.html",
                "Polican.html",
                "Progonat.html",
                "Qeparo.html",
                "Sarande.html",
                "Senice.html",
                "Sheper.html",
                "Skore.html",
                "Sopik.html",
                "Tepelene.html",
                "Zhulat.html",
        };

        fid = getIntent().getStringExtra("fid");


        webview = (WebView) findViewById(R.id.webView);
        webview.getSettings().setLoadWithOverviewMode(true);
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().getJavaScriptEnabled();
        webview.getSettings().setBuiltInZoomControls(true);
        webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webview.setScrollbarFadingEnabled(false);
        webview.loadUrl("file:///android_asset/" + asset_files[Integer.parseInt(fid)]);

        webview.setOnKeyListener( new View.OnKeyListener() {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event ) {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
                    webview.goBack();
                    return true;
                }
                return false;
            }
        });

        ImageButton imgbtnback = (ImageButton) findViewById(R.id.imgbtnback);
        imgbtnback.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                CitiesDesc.this.finish();
            }
        });
    }
}
