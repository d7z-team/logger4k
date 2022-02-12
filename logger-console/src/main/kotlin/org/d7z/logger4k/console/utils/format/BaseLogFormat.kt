package org.d7z.logger4k.console.utils.format

import java.time.LocalDateTime

/**
 * 日志格式化方案接口
 *
 * @constructor
 */
abstract class BaseLogFormat(val rule: String) {

    abstract fun loggerToString(
        name: String,
        thread: Thread,
        date: LocalDateTime,
        level: org.d7z.logger4k.core.LoggerLevel,
        message: String,
        exception: Throwable?,
    ): String
}
