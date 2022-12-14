package ir.aminrahkan.instagramsample.app.utils

import android.content.Context


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/14/22 - 2022
// Project name : Instagram Sample




fun getScreenWidth(context: Context): Int {
    return context.resources.displayMetrics.widthPixels
}

fun getScreenHeight(context: Context): Int {
    return context.resources.displayMetrics.heightPixels
}
