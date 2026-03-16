package com.srinkhla.controller;
import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // यह लाइन अब ऐप को चेहरा (Layout) देगी
        setContentView(R.layout.activity_main);
    }
}
