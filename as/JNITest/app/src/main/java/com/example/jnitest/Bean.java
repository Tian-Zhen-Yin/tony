package com.example.jnitest;


import android.util.Log;

public class Bean {
    private static final String TAG="Bean";
    int i=100;

    public int getI() {
        return i;
    }

    public void setI(int i)
    {
        Log.e(TAG,"有人调用了java的setI");
        this.i = i;
    }
    //静态方法
    public static void printInfo(String msg) {
        Log.e(TAG,msg);
    }

    public static void printInfo(Bean2 bean)
    {
    Log.e(TAG,"参数 "+bean.i);
    }
}
