package model

enum class LogLevel(val priority: Int) {
    DEBUG(1),
    INFO(2),
    WARNING(3),
    ERROR(4),
    FATAL(5);

    companion object {
        fun fromString(level: String): LogLevel? {
            return values().find { it.name.equals(level, ignoreCase = true) }
        }
    }
}
