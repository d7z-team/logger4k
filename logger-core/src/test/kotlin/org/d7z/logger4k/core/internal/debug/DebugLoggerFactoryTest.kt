package org.d7z.logger4k.core.internal.debug

import org.d7z.logger4k.core.LoggerFactory
import org.junit.jupiter.api.Test

internal class DebugLoggerFactoryTest {
    @Test
    fun test() {
        System.setProperty("log.internal.debug", "true")
        val logger = LoggerFactory.internal.getLogger(this::class)
        logger.trace("Hello World,{}.", "dragon")
        logger.debug("Hello World,{}.", "dragon")
        logger.info("Hello World,{}.", "dragon")
        logger.warn("Hello World,{}.", "dragon")
        logger.error("Hello World,{}.", "dragon")
    }
}
