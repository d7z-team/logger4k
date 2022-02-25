package org.d7z.logger4k.forward

import org.d7z.logger4k.core.api.ILogger
import org.d7z.logger4k.core.api.ILoggerFactory
import org.slf4j.LoggerFactory

class ForwardLoggerFactory : ILoggerFactory {
    override fun getLogger(name: String): ILogger {
        return SLF4JLogger(name, LoggerFactory.getLogger(name))
    }
}
