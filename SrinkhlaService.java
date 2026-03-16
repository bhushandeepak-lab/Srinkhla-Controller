package com.srinkhla.controller;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import android.os.Environment;

public class SrinkhlaService extends AccessibilityService {
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {}

    @Override
    public void onInterrupt() {}

    // फाइल बनाने और एडिट करने की पावर
    public void manageFile(String fileName, String content) {
        File file = new File(Environment.getExternalStorageDirectory(), fileName);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
