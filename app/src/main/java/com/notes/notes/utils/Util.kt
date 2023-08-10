package com.notes.notes.utils

import java.text.SimpleDateFormat
import java.util.*

class Util {
    companion object{

        fun getDate(timeStamp : Long) : String{
            val sdf = SimpleDateFormat("MMMM dd, yyyy")
            return sdf.format(Date(timeStamp))
        }
    }
}