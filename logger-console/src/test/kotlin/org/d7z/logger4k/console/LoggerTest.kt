package org.d7z.logger4k.console

import org.d7z.logger4k.core.utils.getLogger
import org.junit.jupiter.api.Test

class LoggerTest {
    @Test
    fun test() {
        System.setProperty("log.internal.debug", "true")
        val logger = getLogger()
        logger.info("Hello World .{}", "dragon")
    }
}
