package org.d7z.logger4k.core.internal

import org.d7z.logger4k.core.ILoggerFactory
import org.d7z.logger4k.core.api.ILoggerSearch
import org.d7z.logger4k.core.internal.debug.DebugLogOutput
import org.d7z.logger4k.core.internal.debug.DebugLoggerFactory
import org.d7z.logger4k.core.internal.produce.ProdLoggerFactory
import org.d7z.logger4k.core.internal.search.DefaultLogSearch
import org.d7z.logger4k.core.utils.IMessageFormat
import org.d7z.logger4k.core.utils.SimpleMessageFormat
import org.d7z.logger4k.core.utils.SpiSearch

/**
 * 内部配置记录
 */
object Logger4KConfig {
    /**
     * 日志消息格式化工具
     */
    val messageFormat = SpiSearch.search(IMessageFormat::class, SimpleMessageFormat()).get()

    /**
     * 内部日志
     */
    val debugLoggerFactory: ILoggerFactory by lazy {
        DebugLoggerFactory(DebugLogOutput())
    }

    /**
     * 外部日志
     */
    val produceLoggerFactory: ILoggerFactory by lazy {
        ProdLoggerFactory()
    }

    /**
     * 日志实现加载器
     */
    val loggerSearch = SpiSearch.search(ILoggerSearch::class, DefaultLogSearch())
}
