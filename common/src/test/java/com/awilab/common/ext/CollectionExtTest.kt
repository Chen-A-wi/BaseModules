package com.awilab.common.ext

import com.awilab.testing.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.properties.Delegates

internal class CollectionExtTest {
    private var intList: List<Int> by Delegates.notNull()

    @BeforeEach
    fun setUp() {
        intList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    }

    @Test
    @DisplayName("測試with List不為空的狀況")
    fun withNotNullAndEmptyTest() {
        intList.withNotNullAndEmpty {
            this shouldBe listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        }
    }

    @Test
    @DisplayName("測試with List為空的狀況")
    fun withEmptyTest() {
        intList = emptyList()

        intList.withNotNullAndEmpty {} shouldBe Unit
    }

    @Test
    @DisplayName("測試when List不為空的狀況")
    fun whenNotNullAndEmpty() {
        intList.whenNotNullAndEmpty {
            it shouldBe listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        }
    }

    @Test
    @DisplayName("測試when List為空的狀況")
    fun whenEmptyTest() {
        intList = emptyList()

        intList.whenNotNullAndEmpty {} shouldBe Unit
    }
}