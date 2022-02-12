package org.d7z.logger4k.forward.slf4j

import org.d7z.logger4k.core.api.ILogOutputApi
import org.d7z.logger4k.forward.IForwardApi

class SLF4JLogApi : IForwardApi {
    override val checkClassName: String = "org.slf4j.Logger"

    override val name = "SlF4JLog"

    override fun init(): ILogOutputApi {
        return SLF4JLogOutputApi()
    }
}
