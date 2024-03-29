package com.awilab.testing

import com.google.common.truth.Truth

infix fun <T> T.shouldBe(that:T) = Truth.assertThat(that).isEqualTo(this)