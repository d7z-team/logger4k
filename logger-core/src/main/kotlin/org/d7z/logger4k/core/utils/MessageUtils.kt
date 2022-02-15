package org.d7z.logger4k.core.utils

import org.d7z.logger4k.core.pub.IMessageFormat
import java.util.LinkedList

/**
 * 日志消息工具类
 */
object MessageUtils : IMessageFormat {
    override fun format(message: String, data: Array<out Any?>): String {
        if (data.isEmpty()) {
            return message
        }
        var lastIndex = 0
        val list = LinkedList<Int>()
        while (true) {
            val index = message.indexOf("{}", lastIndex)
            if (index == -1) {
                break
            }
            if (index != 0) {
                if (message[index - 1] != '\\') {
                    list.add(index)
                    lastIndex = index + 2
                    list.add(lastIndex)
                } else {
                    lastIndex = index + 3
                }
            } else {
                list.add(index)
                lastIndex = index + 2
                list.add(lastIndex)
            }
        }
        if (list.size == 0) {
            return message
        }
        list.addFirst(0)
        list.addLast(message.length)
        val res = ArrayList<String>(list.size + data.size)
        for (i in list.windowed(2, 2)) {
            res.add(message.substring(i[0], i[1]))
        }
        val result = StringBuilder()
        for ((i, v) in res.withIndex()) {
            result.append(v)
            val last = res.size - 1
            if (i == last) {
                break
            }
            if (i < data.size) {
                val any = data[i]
                result.append(any.toString())
            } else if (i < last) {
                result.append("{}")
            }
        }
        return result.toString().replace(regex = Regex("(\\\\\\{}|\\\\\\{\\\\})"), replacement = "{}")
    }
}
