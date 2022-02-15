package org.d7z.logger4k.forward.jul

import org.d7z.logger4k.core.pub.ILogOutputApi
import org.d7z.logger4k.forward.IForwardApi

class JULLogApi : IForwardApi {
    override val checkClassName = "java.util.logging.Level"
    override val name = "Java Utils Logging"

    override fun init(): ILogOutputApi {
        return JULLogOutputApi()
    }
}
