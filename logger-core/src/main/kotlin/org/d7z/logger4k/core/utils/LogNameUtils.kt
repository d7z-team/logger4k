package org.d7z.logger4k.core.utils

import org.d7z.logger4k.core.pub.INameFormat

/**
 * 日志名称工具类
 */
object LogNameUtils : INameFormat {
    private const val maxLength = 40
    override fun format(name: String): String = format(name, maxLength)

    fun format(name: String, maxLength: Int): String {

        if (maxLength == -1) {
            return name
        }
        return if (name.length > maxLength) {
            var length = name.length
            var accept = false
            val builder = StringBuilder()
            val split = name.split(".")
            if (split.size == 1) {
                return formatLength(name, maxLength)
            }
            for (item in 0 until split.size - 1) {
                if (accept) {
                    builder.append(split[item]).append(".") // 无法满足要求
                } else {
                    if ((length + 2 - split[item].length) <= maxLength) {
                        accept = true
                    }
                    builder.append(split[item].first()).append(".")
                    length -= split[item].length - 2
                }
            }

            val lastName = split.last()
            if (lastName.length > maxLength - builder.length) {
                builder.append(lastName)
                builder.substring(builder.length - maxLength, builder.length)
            } else {
                builder.append(lastName)
                formatLength(builder.toString(), maxLength)
            }
        } else {
            formatLength(name, maxLength)
        }
    }

    private fun formatLength(data: String, len: Int): String {
        if (len <= 0) {
            return ""
        }
        return String.format(
            "%${-len}s",
            data.substring(
                0, data.length.coerceAtMost(len)
            )
        )
    }
}
