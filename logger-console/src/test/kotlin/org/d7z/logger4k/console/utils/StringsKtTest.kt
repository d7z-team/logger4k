package org.d7z.logger4k.console.utils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class StringsKtTest {
    @Test
    fun formatTest() {
        assertEquals(10, "data".formatLength(10).length)
        assertEquals(1, "data".formatLength(1).length)
    }

    @Test
    fun toIntOrDefaultTest() {
        assertEquals(12, "12".toIntOrDefault(10))
        assertEquals(-12, "-12".toIntOrDefault(10))
        assertEquals(10, "-12d".toIntOrDefault(10))
    }

    @Test
    fun toEnumOrDefaultTest() {
        assertEquals(
            org.d7z.logger4k.core.LoggerLevel.INFO,
            "INFO".toEnumOrDefault(true, org.d7z.logger4k.core.LoggerLevel.ERROR)
        )
        assertEquals(
            org.d7z.logger4k.core.LoggerLevel.INFO,
            "info".toEnumOrDefault(true, org.d7z.logger4k.core.LoggerLevel.ERROR)
        )
        assertEquals(
            org.d7z.logger4k.core.LoggerLevel.ERROR,
            "warn".toEnumOrDefault(false, org.d7z.logger4k.core.LoggerLevel.ERROR)
        )
        assertEquals(
            org.d7z.logger4k.core.LoggerLevel.ERROR,
            "warn1".toEnumOrDefault(false, org.d7z.logger4k.core.LoggerLevel.ERROR)
        )
    }
}
