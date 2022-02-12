package org.d7z.logger4k.console.utils.format.impl

import org.d7z.logger4k.console.utils.format.BaseFormatRule
import org.d7z.logger4k.console.utils.format.IFormatRuleInfo
import org.d7z.logger4k.console.utils.toEnumOrDefault
import org.d7z.logger4k.core.utils.ThrowableUtils

class ThrowsRuleInfo : IFormatRuleInfo<Throwable?> {
    override val name: String = "throws"

    enum class ThrowsType {
        ALL,
        MESSAGE,
        NONE
    }

    override fun generateRule(rule: String) = object : BaseFormatRule<Throwable?>(rule) {
        override val name: String = this@ThrowsRuleInfo.name
        private val level = rule.toEnumOrDefault(true, ThrowsType.NONE)
        override fun format(data: Throwable?): String {
            if (data == null || level == ThrowsType.NONE) {
                return ""
            }
            return when (level) {
                ThrowsType.ALL -> ThrowableUtils.format(data)
                ThrowsType.MESSAGE -> data.message ?: ""
                else -> ""
            }
        }
    }
}
