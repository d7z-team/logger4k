package org.d7z.logger4k.forward

import org.d7z.logger4k.core.LoggerLevel
import org.d7z.logger4k.core.api.AbstractLogger
import org.slf4j.Logger
import java.time.LocalDateTime

class SLF4JLogger(override val name: String, private val logger: Logger) : AbstractLogger() {
    override val level: LoggerLevel
        get() = when {
            logger.isTraceEnabled -> LoggerLevel.TRACE
            logger.isDebugEnabled -> LoggerLevel.DEBUG
            logger.isInfoEnabled -> LoggerLevel.INFO
            logger.isWarnEnabled -> LoggerLevel.WARN
            logger.isErrorEnabled -> LoggerLevel.ERROR
            else -> LoggerLevel.OFF
        }

    override fun output(
        name: String,
        thread: Thread,
        date: LocalDateTime,
        level: LoggerLevel,
        message: String,
        throwable: Throwable?,
    ) {
        when (level) {
            LoggerLevel.TRACE -> logger.trace(message, throwable)
            LoggerLevel.DEBUG -> logger.debug(message, throwable)
            LoggerLevel.INFO -> logger.info(message, throwable)
            LoggerLevel.WARN -> logger.warn(message, throwable)
            LoggerLevel.ERROR -> logger.error(message, throwable)
            LoggerLevel.OFF -> return
        }
    }
}
