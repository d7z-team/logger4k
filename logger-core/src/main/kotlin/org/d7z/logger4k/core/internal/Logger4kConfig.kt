package org.d7z.logger4k.core.internal

import org.d7z.logger4k.core.LoggerLevel
import org.d7z.logger4k.core.api.ILoggerFactory
import org.d7z.logger4k.core.internal.simple.SPISearch
import org.d7z.logger4k.core.internal.simple.SimpleLoggerFactory

object Logger4kConfig {
    val loggerFactory: ILoggerFactory by lazy {
        val search = SPISearch.search(ILoggerFactory::class, SimpleLoggerFactory())
        if (search.size > 1) {
            System.err.println(
                """
                在类路径下扫描到多个兼容的实现, 为保证日志输出的统一性，请考虑移除不需要的实现.
                
                兼容的实现包括：
                
                ${search.map { " - 名称：" + it.javaClass.name + ", 模块：" + it.javaClass.module.name + " \r\n" }}
                """.trimIndent()
            )
        }
        search.first()
    }

    val loggerLevel: LoggerLevel by lazy {
        try {
            LoggerLevel.valueOf(
                System.getProperty(
                    "logger.level",
                    System.getProperty(
                        "logger4k.level",
                        System.getProperty(
                            "log.level", "OFF"
                        )
                    )
                ).uppercase()
            )
        } catch (e: Exception) {
            LoggerLevel.OFF
        }
    }
}
