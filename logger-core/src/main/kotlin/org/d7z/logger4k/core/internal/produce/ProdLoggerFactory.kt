package org.d7z.logger4k.core.internal.produce

import org.d7z.logger4k.core.ILogger
import org.d7z.logger4k.core.ILoggerFactory
import org.d7z.logger4k.core.LoggerFactory
import org.d7z.logger4k.core.api.ILogOutputApi
import org.d7z.logger4k.core.internal.Logger4KConfig
import org.d7z.logger4k.core.internal.SimpleLogger
import java.util.concurrent.ConcurrentHashMap
import kotlin.reflect.KClass

/**
 * 实际使用的日志初始化类
 */
internal class ProdLoggerFactory : ILoggerFactory {
    private val logOutput: ILogOutputApi
    private val logger = LoggerFactory.internal.getLogger(ProdLoggerFactory::class)

    init {
        val search = Logger4KConfig.loggerSearch.get().search()
        logOutput = if (search.isEmpty()) {
            EmptyLogOutputApi()
        } else {
            if (search.size > 1) {
                logger.warn(
                    "注意，发现多个日志实现类 [{}]，请检查是否存在重复引用问题.",
                    search.map { it::class.qualifiedName }.joinToString()
                )
            }
            val first = search.first()
            try {
                logger.debug("此进程使用实现模块 ：{}.", first.name)
                first.init()
            } catch (e: Exception) {
                EmptyLogOutputApi()
            }
        }
    }

    override fun getLogger(clazz: Class<*>): ILogger {
        return getLogger(clazz.name ?: "\$InnerClass")
    }

    override fun getLogger(clazz: KClass<*>): ILogger {
        return getLogger(clazz.java)
    }

    private val map = ConcurrentHashMap<String, ILogger>()
    override fun getLogger(name: String): ILogger {
        return map[name] ?: kotlin.run {
            val simpleLogger = SimpleLogger(name, logOutput, Logger4KConfig.messageFormat)
            map.putIfAbsent(name, simpleLogger) ?: simpleLogger
        }
    }
}
