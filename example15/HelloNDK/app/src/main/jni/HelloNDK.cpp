//
// Created by dej on 2016/11/13.
//
#include "com_jikexueyuan_hellondk_GetString.h"

JNIEXPORT jstring JNICALL Java_com_jikexueyuan_hellondk_GetString_getStr
  (JNIEnv *env, jclass) {
    return env->NewStringUTF("Static Method Call");
}

