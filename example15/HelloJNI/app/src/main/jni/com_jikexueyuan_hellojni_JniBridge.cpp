//
// Created by dej on 2016/11/13.
//

#include "com_jikexueyuan_hellojni_JniBridge.h"

jstring Java_com_jikexueyuan_hellojni_JniBridge_getString
        (JNIEnv *env, jclass) {
    return env->NewStringUTF("Hello NDK");
}
