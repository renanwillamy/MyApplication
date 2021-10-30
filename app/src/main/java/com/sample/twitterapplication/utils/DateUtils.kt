package com.sample.twitterapplication.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

object DateUtils {

    private fun getDateTime(s: String): LocalDateTime? {
        return try {
            val formatter = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN, Locale.ENGLISH)
            LocalDateTime.parse(s, formatter)
        } catch (e: Exception) {
            e.toString()
            null
        }
    }

    fun getHour(s: String): String {
        val dateTime = getDateTime(s)
        return dateTime?.hour?.toString() ?: EMPTY
    }
}