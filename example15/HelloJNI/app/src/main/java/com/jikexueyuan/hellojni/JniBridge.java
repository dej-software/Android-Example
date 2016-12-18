package com.jikexueyuan.hellojni;

/**
 * Created by dej on 2016/11/13.
 */
public class JniBridge {

    public static native String getString();

    static {
        System.loadLibrary("hellojni");
    }
}
