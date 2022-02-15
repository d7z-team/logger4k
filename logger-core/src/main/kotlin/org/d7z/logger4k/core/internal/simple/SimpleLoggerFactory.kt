package org.d7z.logger4k.core.internal.simple

import org.d7z.logger4k.core.api.ILogger
import org.d7z.logger4k.core.pub.AbstractLoggerFactory
import java.util.concurrent.ConcurrentHashMap

class SimpleLoggerFactory : AbstractLoggerFactory() {
    private val map = ConcurrentHashMap<String, ILogger>()

    override fun getLogger(name: String): ILogger {
        return map[name] ?: kotlin.run {
            val simpleLogger = SimpleLogger(name)
            map.putIfAbsent(name, simpleLogger) ?: simpleLogger
        }
    }
}
