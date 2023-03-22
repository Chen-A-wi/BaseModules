package com.awilab.common.ext

import com.awilab.testing.shouldBe
import org.junit.Before
import org.junit.Test
//import org.junit.jupiter.api.DisplayName
import org.threeten.bp.LocalDateTime

class DateExtTest {
    private lateinit var localDateTime: LocalDateTime

    @Before
    fun setUp() {
        localDateTime = LocalDateTime.of(2022, 12, 13, 8, 8, 8)
    }

    @Test
//    @DisplayName("測試 LocalDateTime to Timestamp")
    fun localDateTimeToTimestampTest() {
        localDateTime.timestamp shouldBe 1670890088000
    }
}