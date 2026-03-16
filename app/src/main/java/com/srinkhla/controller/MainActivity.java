package com.srinkhla.controller;
import android.app.Activity;
import android.os.Bundle;
import android.Manifest;
import android.content.pm.PackageManager;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ऐप खुलते ही कैमरा और ऑडियो की परमिशन माँगने का कोड
        String[] permissions = {Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO};
        
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(permissions, 100);
        }
    }
}
