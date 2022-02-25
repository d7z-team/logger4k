package org.d7z.logger4k.core.internal.simple

import org.d7z.logger4k.core.LoggerLevel
import org.d7z.logger4k.core.LoggerLevel.* // ktlint-disable no-wildcard-imports
import org.d7z.logger4k.core.api.AbstractLogger
import org.d7z.logger4k.core.internal.Logger4kConfig
import org.d7z.logger4k.core.internal.simple.format.LoggerNameFormat
import org.d7z.logger4k.core.internal.simple.format.ThrowableFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class SimpleLogger(override val name: String) : AbstractLogger() {
    private val dateFormat = DateTimeFormatter.ofPattern("YY/MM/dd HH:mm:ss")

    override fun output(
        name: String,
        thread: Thread,
        date: LocalDateTime,
        level: LoggerLevel,
        message: String,
        throwable: Throwable?,
    ) {
        when (level) {
            INFO, TRACE, DEBUG -> System.out
            WARN, ERROR -> System.err
            OFF -> null
        }?.let {
            val buf = StringBuffer()
            buf.append(dateFormat.format(date))
                .append(" - ")
                .append(
                    String.format(
                        "%-5s",
                        level.toString().substring(
                            0, level.toString().length.coerceAtMost(5)
                        )
                    )
                ).append(" - ")
                .append(
                    String.format(
                        "%-15s",
                        (thread.name ?: "unknown").substring(
                            0, level.toString().length.coerceAtMost(15) // Thread
                        )
                    )
                ).append(" - ")
                .append(LoggerNameFormat.format(name, 40)) // package
                .append(":")
                .append(message) // message
            if (throwable != null) {
                buf.append("\r\n")
                    .append(ThrowableFormat.format(throwable))
            }
            println(buf)
            buf.delete(0, buf.length)
        }
    }

    override val level: LoggerLevel
        get() = Logger4kConfig.loggerLevel
}
