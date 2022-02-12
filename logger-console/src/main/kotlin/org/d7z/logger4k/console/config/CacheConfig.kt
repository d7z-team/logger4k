package org.d7z.logger4k.console.config

import org.d7z.logger4k.console.output.CacheLogOutputApi
import org.d7z.logger4k.console.output.ConsoleLogOutputApi
import org.d7z.logger4k.console.utils.Config
import org.d7z.logger4k.core.api.ILogOutputApi

object CacheConfig : Config.ConfigItem<ILogOutputApi> {
    override val key = "logger.output.cache"
    override val defaultValue = ConsoleLogOutputApi

    override fun toString(data: ILogOutputApi): String {
        return (data == defaultValue).toString()
    }

    override fun parseString(data: String): ILogOutputApi {
        return if (data == "true") {
            CacheLogOutputApi(ConsoleLogOutputApi)
        } else {
            defaultValue
        }
    }
}
