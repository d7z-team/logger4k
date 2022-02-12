package org.d7z.logger4k.core.api

import java.time.LocalDateTime

/**
 * 日志处理
 */
interface ILogOutputApi {
    /**
     *
     * 输出的日志等级
     */
    fun outputLevel(name: String): org.d7z.logger4k.core.LoggerLevel

    /**
     * 日志处理
     *
     * @param name String 日志名称
     * @param thread Thread 触发日志的线程
     * @param date LocalDateTime 日志发生时间
     * @param level LoggerLevel 日志等级
     * @param message String 日志内容
     */
    fun outputLogger(
        name: String,
        thread: Thread,
        date: LocalDateTime,
        level: org.d7z.logger4k.core.LoggerLevel,
        message: String,
    )

    /**
     * 日志处理
     *
     * @param name String 日志名称
     * @param thread Thread 触发日志的线程
     * @param date LocalDateTime 日志发生时间
     * @param level LoggerLevel 日志等级
     * @param message String 日志内容
     * @param exception Throwable 日志错误消息
     */
    fun outputLogger(
        name: String,
        thread: Thread,
        date: LocalDateTime,
        level: org.d7z.logger4k.core.LoggerLevel,
        message: String,
        exception: Throwable,
    )
}
