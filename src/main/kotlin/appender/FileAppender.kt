package appender

import model.LogAppender
import model.LogMessage
import java.io.File
import java.io.FileWriter
import java.io.BufferedWriter

class FileAppender(private val fileName: String) : LogAppender {

    private val writer: BufferedWriter

    init {
        val file = File(fileName)
        writer = BufferedWriter(FileWriter(file, true))  // Open file in append mode
    }

    override fun append(logMessage: LogMessage) {
        writer.write(logMessage.toString() + "\n")  // ✅ Uses overridden toString() with [timestamp] and [level]
        writer.flush()  // Ensure immediate write to the file
    }

    fun close() {
        writer.close()  // Close file when done
    }
}
