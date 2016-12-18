package com.jikexueyuan.hellokotlin

import android.content.Context
import android.widget.Toast

/**
 * Created by dej on 2016/9/13.
 */
class Tools {

    companion object {
        fun showToast(c:Context, msg:String) {
            Toast.makeText(c, msg, Toast.LENGTH_SHORT).show()
        }
    }
}