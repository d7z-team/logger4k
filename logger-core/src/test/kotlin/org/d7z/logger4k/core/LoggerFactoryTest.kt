package org.d7z.logger4k.core

import org.d7z.logger4k.core.internal.simple.SimpleLoggerFactory
import org.junit.jupiter.api.Test

internal class LoggerFactoryTest {
    @Test
    fun testAll() {
        Thread.currentThread().name = "Test1"
        System.setProperty("logger.level", "TRACE")
        val logger = LoggerFactory.getLogger(SimpleLoggerFactory::class)
        logger.trace("Hello World")
        logger.debug("Hello World")
        logger.info("Hello World")
        logger.warn("Hello World")
        logger.error("Hello World")
    }
}
