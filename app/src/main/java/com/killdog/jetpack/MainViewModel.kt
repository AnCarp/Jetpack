package com.killdog.jetpack

import androidx.lifecycle.ViewModel

class MainViewModel(countReserved:Int):ViewModel() {
    var counter=countReserved
}