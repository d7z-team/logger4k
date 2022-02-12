import org.d7z.logger4k.core.LoggerFactory
import org.junit.jupiter.api.Test

class TestSlf4J {

    @Test
    fun test() {
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
