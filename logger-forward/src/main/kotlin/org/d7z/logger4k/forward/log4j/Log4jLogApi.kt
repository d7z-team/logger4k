package org.d7z.logger4k.forward.log4j

import org.d7z.logger4k.core.pub.ILogOutputApi
import org.d7z.logger4k.forward.IForwardApi

class Log4jLogApi : IForwardApi {
    override val checkClassName = "org.apache.logging.log4j.LogManager"
    override val name = "Apache Log4j"

    override fun init(): ILogOutputApi {
        return Log4jLogOutputApi()
    }
}
