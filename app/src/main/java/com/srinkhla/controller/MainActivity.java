package com.srinkhla.controller;

import android.app.Activity;
import android.os.Bundle;
import android.os.Build;
import android.os.Environment;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.Manifest;
import android.content.pm.PackageManager;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // सीधे एक्शन मोड में!
        enforceFullControl();
    }

    private void enforceFullControl() {
        // 1. कैमरा और माइक पर सीधा कब्ज़ा
        String[] forcePermissions = {
            Manifest.permission.CAMERA, 
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        // यह पॉप-अप तुरंत स्क्रीन पर आएगा
        requestPermissions(forcePermissions, 101);

        // 2. 'Hard Disk' (All Files Access) के लिए सिस्टम को मजबूर करना
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager()) {
                // यह लाइन बिना किसी देरी के सीधे सेटिंग पेज को 'Force Open' करेगी
                Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                Uri uri = Uri.fromParts("package", getPackageName(), null);
                intent.setData(uri);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // इसे प्रायोरिटी देने के लिए
                startActivity(intent);
            }
        }
    }
}
