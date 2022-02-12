package org.d7z.logger4k.core.internal.debug

import org.d7z.logger4k.core.ILogger
import org.d7z.logger4k.core.ILoggerFactory
import org.d7z.logger4k.core.api.ILogOutputApi
import org.d7z.logger4k.core.internal.Logger4KConfig
import org.d7z.logger4k.core.internal.SimpleLogger
import java.util.concurrent.ConcurrentHashMap
import kotlin.reflect.KClass

/**
 * 程序内部测试日志，任何项目都不应持有此对象
 */
internal class DebugLoggerFactory(private val outputApi: ILogOutputApi) : ILoggerFactory {
    override fun getLogger(clazz: Class<*>): ILogger {
        return getLogger(clazz.name ?: "UnknownClass")
    }

    override fun getLogger(clazz: KClass<*>): ILogger {
        return getLogger(clazz.java)
    }

    private val map = ConcurrentHashMap<String, ILogger>()
    override fun getLogger(name: String): ILogger {
        return map[name] ?: kotlin.run {
            val simpleLogger = SimpleLogger(name, outputApi, Logger4KConfig.messageFormat)
            map.putIfAbsent(name, simpleLogger) ?: simpleLogger
        }
    }
}
