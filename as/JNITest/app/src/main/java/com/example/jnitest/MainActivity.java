package com.example.jnitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    //JNI是框架，桥梁
    //
    static {
        //生成动态库
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int i[]={1,2,3,4,5};
        String s[]={"YIN","TAO"};
        test(i,s);
        Log.e("Java","int数组："+ Arrays.toString(i));

        //传递引用类型
        Bean bean=new Bean();
        passObject(bean,"我知道");
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

    public native int test(int[] i,String[] j);
    public native void passObject(Bean bean,String string);

}
