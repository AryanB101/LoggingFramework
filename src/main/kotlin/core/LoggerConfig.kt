package core

import model.LogAppender
import model.LogLevel
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.atomic.AtomicReference

class LoggerConfig(
    logLevel: LogLevel = LogLevel.DEBUG,
    appenders: List<LogAppender> = listOf()
) {
    private val currentLogLevel = AtomicReference(logLevel)
    private val logAppenders = CopyOnWriteArrayList(appenders)

    fun getLogLevel(): LogLevel = currentLogLevel.get()

    fun setLogLevel(level: LogLevel) {
        currentLogLevel.set(level)
    }

    fun getAppenders(): List<LogAppender> = logAppenders.toList()

    fun addAppender(appender: LogAppender) {
        logAppenders.add(appender)
    }

    fun clearAppenders() {
        logAppenders.clear()
    }

    fun setAppenders(newAppenders: List<LogAppender>) {
        logAppenders.clear()
        logAppenders.addAll(newAppenders)
    }
}
