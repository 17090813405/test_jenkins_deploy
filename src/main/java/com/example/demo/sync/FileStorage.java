package com.example.demo.sync;

import com.example.demo.apple.InApp;

import static java.lang.Thread.sleep;

/**
 * Created by WY on 2018/10/13.
 */
public class FileStorage {

    public InApp inApp = new InApp();
//    public static final String key1 = "rw_data";

    public void writeUserActions() {
        synchronized (inApp) {
            System.out.println(System.currentTimeMillis());
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
