package com.jikexueyuan.hellondk;

/**
 * javah -d jni -jni -classpath ..\..\build\intermediates\classes\debug com.jikexueyuan.hellondk.GetString
 * Created by dej on 2016/11/13.
 */
public class GetString {

    static {
        System.loadLibrary("HelloNDK");
    }

    public static native String getStr();
}
