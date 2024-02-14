package com.example.zoho.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.TimeZone

fun getCurrentTimeInIST(): String {
    val dateFormat = SimpleDateFormat("HH:mm")
    dateFormat.timeZone = TimeZone.getTimeZone("Asia/Kolkata")

    val currentTime = Calendar.getInstance().time
    return dateFormat.format(currentTime)
}