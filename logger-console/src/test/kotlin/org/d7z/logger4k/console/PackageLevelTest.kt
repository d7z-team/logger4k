package org.d7z.logger4k.console

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PackageLevelTest {

    @Test
    fun test() {
        val packageLevel = PackageLevel(org.d7z.logger4k.core.LoggerLevel.INFO)
        assertEquals(org.d7z.logger4k.core.LoggerLevel.INFO, packageLevel.getPackageLevel("com.example"))
        packageLevel.putPackageLevel("com.example.dragon", org.d7z.logger4k.core.LoggerLevel.ERROR)
        assertEquals(org.d7z.logger4k.core.LoggerLevel.INFO, packageLevel.getPackageLevel("com.example"))
        assertEquals(org.d7z.logger4k.core.LoggerLevel.ERROR, packageLevel.getPackageLevel("com.example.dragon"))
        packageLevel.putPackageLevel("com", org.d7z.logger4k.core.LoggerLevel.OFF)
        assertEquals(org.d7z.logger4k.core.LoggerLevel.OFF, packageLevel.getPackageLevel("com.example"))
    }
}
