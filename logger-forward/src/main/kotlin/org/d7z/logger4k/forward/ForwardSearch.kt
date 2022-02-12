package org.d7z.logger4k.forward

import org.d7z.logger4k.core.api.ILogApi
import org.d7z.logger4k.core.api.ILoggerSearch
import org.d7z.logger4k.forward.jul.JULLogApi
import org.d7z.logger4k.forward.log4j.Log4jLogApi
import org.d7z.logger4k.forward.slf4j.SLF4JLogApi
import java.util.Optional
import java.util.ServiceLoader

class ForwardSearch : ILoggerSearch {
    private val rules = setOf(
        SLF4JLogApi(),
        Log4jLogApi(),
        JULLogApi(),
    )

    override fun search(): Set<ILogApi> {
        return ServiceLoader.load(ILogApi::class.java)
            .findFirst()
            .or {
                rules.firstOrNull {
                    try {
                        Class.forName(it.checkClassName)
                        true
                    } catch (e: Exception) {
                        false
                    }
                }.let { Optional.ofNullable(it) }
            }
            .map { setOf(it) }
            .orElse(emptySet())
    }
}
