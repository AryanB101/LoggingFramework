package org.example.demo

import appender.ConsoleAppender
import appender.FileAppender


import core.Logger
import model.LogLevel

fun main() {
    // Set log level and add appenders (console and file)
    Logger.setLogLevel(LogLevel.DEBUG)
    Logger.addAppender(ConsoleAppender())
    Logger.addAppender(FileAppender("app.log"))

    // Log messages from the main thread
    Logger.debug("Debugging from main thread")
    Logger.info("Informational log from main thread")
    Logger.warning("Warning from main thread")
    Logger.error("Error encountered in main thread")
    Logger.fatal("Fatal issue in main thread")

    println("Logging from multiple threads:")

    // Launch multiple threads to simulate concurrent logging
    val threads = List(5) { index ->
        Thread {
            Logger.info("Logging from Thread ${index + 1}")
        }
    }

    // Start all threads
    threads.forEach { it.start() }

    // Wait for all threads to finish
    threads.forEach { it.join() }

    println("All threads have completed logging.")
}
