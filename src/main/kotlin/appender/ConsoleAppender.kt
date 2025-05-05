package appender

import model.LogAppender
import model.LogMessage

class ConsoleAppender : LogAppender {
    override fun append(logMessage: LogMessage) {
        // Immediately print log to the console
        println(logMessage)
    }
}
