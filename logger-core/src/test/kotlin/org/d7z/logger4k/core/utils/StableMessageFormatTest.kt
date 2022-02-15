package org.d7z.logger4k.core.utils

import org.d7z.logger4k.core.internal.format.StableMessageFormat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class StableMessageFormatTest {

    @Test
    fun format() {
        val format = StableMessageFormat()
        assertEquals(
            format.format(
                "Hello World, {}.",
                arrayOf("dragon")
            ),
            "Hello World, dragon."
        )

        assertEquals(
            format.format(
                "Hello World, {}.",
                arrayOf()
            ),
            "Hello World, {}."
        )

        assertEquals(
            format.format(
                "Hello World, \\{},{}.",
                arrayOf("dragon")
            ),
            "Hello World, {},dragon."
        )

        assertEquals(
            format.format(
                "{}, Hello World.",
                arrayOf("dragon")
            ),
            "dragon, Hello World."
        )

        assertEquals(
            format.format("{}, Hello World, {}.", arrayOf("dragon", "bye")),
            "dragon, Hello World, bye."
        )

        assertEquals(
            format.format(
                "Hello World, {}.", arrayOf("dragon", "Alice", "Bob")
            ),
            "Hello World, dragon."
        )
    }
}
