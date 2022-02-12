package org.d7z.logger4k.console.utils.format.impl

import org.d7z.logger4k.console.utils.format.BaseFormatRule
import org.d7z.logger4k.console.utils.format.IFormatRuleInfo
import org.d7z.logger4k.console.utils.toIntOrDefault
import org.d7z.logger4k.core.utils.MaxLengthClassFormat

class PkgNameRuleInfo : IFormatRuleInfo<String> {
    override val name = "package"
    override val defaultRule = "30"
    override fun generateRule(rule: String) = object : BaseFormatRule<String>(rule) {
        override val name: String = this@PkgNameRuleInfo.name
        private val formatRule = MaxLengthClassFormat(rule.toIntOrDefault(30))
        override fun format(data: String): String {
            return formatRule.format(data)
        }
    }
}
