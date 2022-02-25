package org.d7z.logger4k.core.api

import kotlin.reflect.KClass

/**
 * 日志工厂
 *
 * @since 0.1.0
 */
interface ILoggerFactory {

    /**
     * 根据 java class 得到日志实例
     */
    fun getLogger(clazz: Class<*>): ILogger {
        return getLogger(clazz.name)
    }

    /**
     * 根据 kotlin class 得到日志实例
     */
    fun getLogger(clazz: KClass<*>): ILogger {
        return getLogger(clazz.javaObjectType)
    }

    /**
     *  根据名称得到日志实例
     */
    fun getLogger(name: String): ILogger
}
