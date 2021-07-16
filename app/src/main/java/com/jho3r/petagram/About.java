package com.jho3r.petagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void goToUrl(View v){

        String url = "";
        switch (v.getId()){
            case R.id.ivFacebook:
                url = "https://www.facebook.com/jho3r/";
                break;
            case R.id.ivInstagram:
                url = "https://www.instagram.com/jho3r/";
                break;
            case R.id.ivTwitter:
                url = "https://twitter.com/jho3r";
                break;
            case R.id.ivGithub:
                url = "https://github.com/jho3r";
                break;
        }

        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}