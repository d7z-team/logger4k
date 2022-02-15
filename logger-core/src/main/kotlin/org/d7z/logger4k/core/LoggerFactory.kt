/*
 * Copyright (c) 2020, OpenEDGN. All rights reserved.
 * HOME Page: https://github.com/OpenEDGN
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.d7z.logger4k.core

import org.d7z.logger4k.core.api.ILogger
import org.d7z.logger4k.core.api.ILoggerFactory
import org.d7z.logger4k.core.internal.Logger4kConfig
import kotlin.reflect.KClass

/**
 * 默认的日志工厂
 *
 * @since 0.1.0
 */
object LoggerFactory : ILoggerFactory {

    override fun getLogger(clazz: Class<*>): ILogger {
        return Logger4kConfig.loggerFactory.getLogger(clazz)
    }

    override fun getLogger(clazz: KClass<*>): ILogger {
        return Logger4kConfig.loggerFactory.getLogger(clazz)
    }

    override fun getLogger(name: String): ILogger {
        return Logger4kConfig.loggerFactory.getLogger(name)
    }
}
