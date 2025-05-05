package core

import model.LogAppender
import model.LogLevel
import model.LogMessage
import java.util.concurrent.atomic.AtomicReference

object Logger {

    private val config: LoggerConfig = LoggerConfig()  // Default config

    // Convenience methods for logging at different levels
    fun debug(message: String) {
        log(LogLevel.DEBUG, message)
    }

    fun info(message: String) {
        log(LogLevel.INFO, message)
    }

    fun warning(message: String) {
        log(LogLevel.WARNING, message)
    }

    fun error(message: String) {
        log(LogLevel.ERROR, message)
    }

    fun fatal(message: String) {
        log(LogLevel.FATAL, message)
    }

    private fun log(level: LogLevel, message: String) {
        if (level.priority >= config.getLogLevel().priority) {
            val logMessage = LogMessage(level = level, message = message)
            config.getAppenders().forEach { it.append(logMessage) }
        }
    }

    // Configuration methods
    fun setLogLevel(level: LogLevel) {
        config.setLogLevel(level)
    }

    fun addAppender(appender: LogAppender) {
        config.addAppender(appender)
    }

    fun clearAppenders() {
        config.clearAppenders()
    }
}
