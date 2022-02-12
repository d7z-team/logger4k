package org.d7z.logger4k.console.utils.format.impl

import org.d7z.logger4k.console.utils.format.BaseFormatRule
import org.d7z.logger4k.console.utils.format.IFormatRuleInfo
import org.d7z.logger4k.console.utils.formatLength
import org.d7z.logger4k.console.utils.toIntOrDefault
import org.d7z.logger4k.core.LoggerLevel

class LogLevelRuleInfo : IFormatRuleInfo<LoggerLevel> {
    override val name: String = "level"
    override fun generateRule(rule: String) = object : BaseFormatRule<LoggerLevel>(rule) {
        override val name: String = this@LogLevelRuleInfo.name
        val length = rule.toIntOrDefault(5)
        override fun format(data: LoggerLevel): String {
            return data.toString().formatLength(length)
        }
    }
}
