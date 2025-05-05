package demo

import core.Logger
import appender.ConsoleAppender
import appender.FileAppender
import model.LogLevel
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

fun main() {
    // Set up different appenders
    val consoleAppender = ConsoleAppender()
    val fileAppender = FileAppender("logs.txt")

    // Configure logger
    Logger.addAppender(consoleAppender)
    Logger.addAppender(fileAppender)
    Logger.setLogLevel(LogLevel.DEBUG)

    // Log various levels
    println("Logging at DEBUG level:")
    Logger.debug("This is a debug message.")
    Logger.info("This is an info message.")
    Logger.warning("This is a warning message.")
    Logger.error("This is an error message.")
    Logger.fatal("This is a fatal message.")

    // Change log level to ERROR and log again
    println("\nLogging at ERROR level:")
    Logger.setLogLevel(LogLevel.ERROR)
    Logger.debug("This debug message should not appear.")
    Logger.error("This is an error message.")
    Logger.fatal("This is a fatal message.")

    // Multi-threaded logging example
    println("\nLogging from multiple threads:")
    val executor = Executors.newFixedThreadPool(2)

    executor.submit {
        Logger.info("Logging from Thread 1")
    }
    executor.submit {
        Logger.warning("Logging from Thread 2")
    }

    // Ensure tasks complete before shutting down
    executor.shutdown()
    // Wait for all tasks to finish
    executor.awaitTermination(1, TimeUnit.MINUTES)

    println("All threads have completed logging.")
}
