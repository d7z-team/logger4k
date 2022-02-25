package org.d7z.logger4k.core.internal.simple

import java.util.ServiceLoader
import kotlin.reflect.KClass

/**
 * Java SPI 加载器
 */
object SPISearch {
    fun <T : Any> search(clazz: KClass<T>, default: T? = null): Set<T> {
        return try {
            ServiceLoader.load(clazz.java).toList().toMutableSet()
        } catch (e: Exception) {
            mutableSetOf<T>()
        }.apply {
            if (default != null && isEmpty()) {
                add(default)
            }
        }
    }
}
