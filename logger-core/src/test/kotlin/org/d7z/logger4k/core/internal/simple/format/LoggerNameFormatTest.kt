package org.d7z.logger4k.core.internal.simple.format

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LoggerNameFormatTest {

    @Test
    fun format() {
        val format = LoggerNameFormat
        assertEquals(
            "c.g.o.l.u.MaxLengthClassFormatTest      ",
            format.format("com.github.openEdgn.logger4k.utils.MaxLengthClassFormatTest", 40)
        )
        assertEquals(
            "c.g.o.l.u.M.TestInternal                ",
            format.format("com.github.openEdgn.logger4k.utils.MaxLengthClassFormatTest.TestInternal", 40)
        )
        assertEquals(
            "f.c.MaxLengthClassFormatTestTestInternal",
            format.format("com.github.openEdgn.logger4k.utils.format.classes.MaxLengthClassFormatTestTestInternal", 40)
        )
        assertEquals(
            "dragon.Test                             ",
            format.format("dragon.Test", 40)
        )
    }
}
