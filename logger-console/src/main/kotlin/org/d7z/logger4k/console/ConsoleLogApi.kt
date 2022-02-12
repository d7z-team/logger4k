package org.d7z.logger4k.console

import org.d7z.logger4k.console.config.CacheConfig
import org.d7z.logger4k.core.api.ILogApi
import org.d7z.logger4k.core.api.ILogOutputApi

class ConsoleLogApi : ILogApi {

    override val name = "ConsoleLog"

    override fun init(): ILogOutputApi {
        return ConsoleLogConfig.config.get(CacheConfig)
    }
}
