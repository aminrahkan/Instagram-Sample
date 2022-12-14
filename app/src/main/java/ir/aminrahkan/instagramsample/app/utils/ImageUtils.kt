package ir.aminrahkan.instagramsample.app.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/14/22 - 2022
// Project name : Instagram Sample


fun getSuitableSizeForImage(@ApplicationContext context: Context): Int {
    return (getScreenWidth(context) * 9) / 16
}