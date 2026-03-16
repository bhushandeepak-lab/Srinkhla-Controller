package com.srinkhla.controller;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. स्क्रीन पर जीत का सिग्नल
        Toast.makeText(this, "श्रृंखला: सारी शक्तियाँ प्राप्त हुईं!", Toast.LENGTH_LONG).show();

        // 2. स्टोरेज में 'विजय स्तंभ' गाड़ना (Test File बनाना)
        createTestBridge();
    }

    private void createTestBridge() {
        try {
            // 'Srinkhla' नाम का फोल्डर बनाना
            File folder = new File(Environment.getExternalStorageDirectory(), "Srinkhla");
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // 'bridge.txt' फाइल बनाना
            File file = new File(folder, "bridge.txt");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write("GEMINI_CONNECTION_SUCCESSFUL".getBytes());
            fos.close();
            
            Toast.makeText(this, "Bridge File Created!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "File Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
