package appender

import model.LogAppender
import model.LogMessage
import kotlin.collections.toList

class DatabaseAppender : LogAppender {

    private val logs: MutableList<LogMessage> = mutableListOf()

    @Synchronized
    override fun append(logMessage: LogMessage) {
        logs.add(logMessage)
    }

    fun getLogs(): List<LogMessage> = logs.toList() // for inspection
}
