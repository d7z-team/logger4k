package org.d7z.logger4k.core.utils

import org.junit.jupiter.api.Test

internal class ThrowableUtilsTest {

    @Test
    fun format() {
        println(ThrowableUtils.format(RuntimeException()))
    }
}
