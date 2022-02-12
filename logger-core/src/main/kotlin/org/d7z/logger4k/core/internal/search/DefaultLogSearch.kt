package org.d7z.logger4k.core.internal.search

import org.d7z.logger4k.core.api.ILogApi
import org.d7z.logger4k.core.api.ILoggerSearch
import java.util.ServiceLoader

/**
 * 基于 Java SPI 搜索,
 */
class DefaultLogSearch : ILoggerSearch {
    override fun search(): Set<ILogApi> {
        val loader = ServiceLoader.load(ILogApi::class.java)
        val hashSet = HashSet<ILogApi>()
        loader.stream().forEach {
            hashSet.add(it.get() as ILogApi)
        }
        return hashSet
    }
}
