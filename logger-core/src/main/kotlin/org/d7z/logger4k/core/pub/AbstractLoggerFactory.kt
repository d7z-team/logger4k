package org.d7z.logger4k.core.pub

import org.d7z.logger4k.core.api.ILogger
import org.d7z.logger4k.core.api.ILoggerFactory
import kotlin.reflect.KClass

/**
 * 抽象化 Logger Factory
 */
abstract class AbstractLoggerFactory : ILoggerFactory {
    override fun getLogger(clazz: Class<*>): ILogger {
        return getLogger(clazz.name)
    }

    override fun getLogger(clazz: KClass<*>): ILogger {
        return getLogger(clazz.javaObjectType)
    }
}
