import org.d7z.logger4k.core.LoggerFactory
import org.junit.jupiter.api.Test
import org.slf4j.simple.SimpleLogger

class TestSlf4J {

    @Test
    fun test() {
        System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "TRACE")

        val logger = LoggerFactory.getLogger(javaClass)
        logger.trace("Hello World")
        logger.debug("Hello World")
        logger.info("Hello World")
        logger.warn("Hello World")
        logger.error("Hello World")
        val thread = Thread {
            logger.error("New Thread")
        }
        thread.name = "Test Thread"
        thread.start()
    }
}
