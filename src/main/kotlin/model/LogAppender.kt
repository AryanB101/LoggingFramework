package model

import model.LogMessage

interface LogAppender {
    fun append(logMessage: LogMessage)
}
