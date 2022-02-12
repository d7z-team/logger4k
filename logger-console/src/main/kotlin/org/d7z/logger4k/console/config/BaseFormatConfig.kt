package org.d7z.logger4k.console.config

import org.d7z.logger4k.console.utils.Config
import org.d7z.logger4k.console.utils.format.BaseLogFormat
import org.d7z.logger4k.console.utils.format.LogFormat

abstract class BaseFormatConfig : Config.ConfigItem<BaseLogFormat> {

    override fun toString(data: BaseLogFormat): String {
        return data.rule
    }

    override fun parseString(data: String): BaseLogFormat {
        return LogFormat(data)
    }
}
