package org.d7z.logger4k.core.pub

import org.d7z.logger4k.core.LoggerLevel
import org.d7z.logger4k.core.api.ILogger
import org.d7z.logger4k.core.utils.MessageUtils
import java.time.LocalDateTime

/**
 * 抽象化 Logger
 */
abstract class AbstractLogger : ILogger {
    companion object {
        private val MESSAGE_FORMAT: IMessageFormat = MessageUtils
    }

    /**
     * Logger 名称
     */
    abstract val name: String

    /**
     * Logger 输出
     *
     * @param name String Logger 名称
     * @param thread Thread Logger 当前线程
     * @param date LocalDateTime Logger 触发时间
     * @param level LoggerLevel Logger 等级
     * @param message String Logger 消息
     * @param throwable Throwable? Logger 产生的错误
     */
    abstract fun output(
        name: String,
        thread: Thread,
        date: LocalDateTime,
        level: LoggerLevel,
        message: String,
        throwable: Throwable? = null,

    )

    /**
     * 当前 Logger level
     */
    abstract override val level: LoggerLevel

    private val messageFormat: IMessageFormat = MESSAGE_FORMAT

    override fun trace(message: String, vararg param: Any?): ILogger {
        if (level.level > LoggerLevel.TRACE.level) {
            return this
        }
        val array = Array<Any?>(param.size) { null }
        System.arraycopy(param, 0, array, 0, array.size)
        output(
            name, Thread.currentThread(), LocalDateTime.now(),
            LoggerLevel.TRACE, messageFormat.format(message, array)
        )
        return this
    }

    override fun debug(message: String, vararg param: Any?): ILogger {
        if (level.level > LoggerLevel.DEBUG.level) {
            return this
        }
        val array = Array<Any?>(param.size) { null }
        System.arraycopy(param, 0, array, 0, array.size)
        output(
            name, Thread.currentThread(), LocalDateTime.now(),
            LoggerLevel.DEBUG, messageFormat.format(message, array)
        )
        return this
    }

    override fun info(message: String, vararg param: Any?): ILogger {
        if (level.level > LoggerLevel.INFO.level) {
            return this
        }
        val array = Array<Any?>(param.size) { null }
        System.arraycopy(param, 0, array, 0, array.size)
        output(
            name, Thread.currentThread(), LocalDateTime.now(),
            LoggerLevel.INFO, messageFormat.format(message, array)
        )
        return this
    }

    override fun warn(message: String, vararg param: Any?): ILogger {
        if (level.level > LoggerLevel.WARN.level) {
            return this
        }
        val array = Array<Any?>(param.size) { null }
        System.arraycopy(param, 0, array, 0, array.size)
        output(
            name, Thread.currentThread(), LocalDateTime.now(),
            LoggerLevel.WARN, messageFormat.format(message, array)
        )
        return this
    }

    override fun error(message: String, vararg param: Any?): ILogger {
        if (level.level > LoggerLevel.ERROR.level) {
            return this
        }
        val array = Array<Any?>(param.size) { null }
        System.arraycopy(param, 0, array, 0, array.size)
        output(
            name, Thread.currentThread(), LocalDateTime.now(),
            LoggerLevel.ERROR, messageFormat.format(message, array)
        )
        return this
    }

    override fun debugThrowable(message: Any, exception: Throwable): ILogger {
        if (level.level > LoggerLevel.DEBUG.level) {
            return this
        }
        output(
            name, Thread.currentThread(), LocalDateTime.now(),
            LoggerLevel.DEBUG, message.toString(), exception
        )
        return this
    }

    override fun infoThrowable(message: Any, exception: Throwable): ILogger {
        if (level.level > LoggerLevel.INFO.level) {
            return this
        }
        output(
            name, Thread.currentThread(), LocalDateTime.now(),
            LoggerLevel.INFO, message.toString(), exception
        )
        return this
    }

    override fun traceThrowable(message: Any, exception: Throwable): ILogger {
        if (level.level > LoggerLevel.TRACE.level) {
            return this
        }
        output(
            name, Thread.currentThread(), LocalDateTime.now(),
            LoggerLevel.TRACE, message.toString(), exception
        )
        return this
    }

    override fun warnThrowable(message: Any, exception: Throwable): ILogger {
        if (level.level > LoggerLevel.WARN.level) {
            return this
        }
        output(
            name, Thread.currentThread(), LocalDateTime.now(),
            LoggerLevel.WARN, message.toString(), exception
        )
        return this
    }

    override fun errorThrowable(message: Any, exception: Throwable): ILogger {
        if (level.level > LoggerLevel.ERROR.level) {
            return this
        }
        output(
            name, Thread.currentThread(), LocalDateTime.now(),
            LoggerLevel.ERROR, message.toString(), exception
        )
        return this
    }

    override fun traceOnly(function: ILogger.() -> Unit): ILogger {
        if (level == LoggerLevel.TRACE) {
            function(this)
        }
        return this
    }

    override fun debugOnly(function: ILogger.() -> Unit): ILogger {
        if (level == LoggerLevel.DEBUG) {
            function(this)
        }
        return this
    }

    override val isDebug: Boolean
        get() = level == LoggerLevel.DEBUG
}
