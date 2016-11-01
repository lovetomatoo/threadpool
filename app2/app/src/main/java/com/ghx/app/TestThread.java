package com.ghx.app;

import android.util.Log;

/**
 * Created by guo_hx on 2016/11/1.15:02
 */

public class TestThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100000000; i++) {
            int j = 1+1;
        }
        Log.i("guohongxin", Thread.currentThread().getName() + "正在执行！" + System.currentTimeMillis());
    }
}
