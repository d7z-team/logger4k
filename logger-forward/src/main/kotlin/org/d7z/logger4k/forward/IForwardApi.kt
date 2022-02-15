package org.d7z.logger4k.forward

import org.d7z.logger4k.core.pub.ILogApi

interface IForwardApi : ILogApi {
    val checkClassName: String
}
