package model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class LogMessage(
    val timestamp: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
    val level: LogLevel,
    val message: String
) {
    override fun toString(): String {
        return "[$timestamp] [${level.name}] $message"
    }
}

