package org.d7z.logger4k.console.utils.format.impl

import org.d7z.logger4k.console.utils.format.BaseFormatRule
import org.d7z.logger4k.console.utils.format.IFormatRuleInfo

class MessageRuleInfo : IFormatRuleInfo<String> {
    override val name = "message"
    override fun generateRule(rule: String) = object : BaseFormatRule<String>(rule) {
        override val name: String = this@MessageRuleInfo.name
        override fun format(data: String): String {
            return data
        }
    }
}
