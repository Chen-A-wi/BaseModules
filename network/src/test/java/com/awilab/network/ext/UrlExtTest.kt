package com.awilab.network.ext

import com.awilab.testing.shouldBe
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.net.URL

internal class UrlExtTest {
    private var fakeAwsUrl =
        "https://jie-storage-test.s3-accelerate.amazonaws.com/product/devicemanager/log/4839e0d8-abdb-4e5a-904c-e0f558cfd095/logact.txt?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIA5VI5KUTXCBUY7K7G%2F20221031%2Fus-east-2%2Fs3%2Faws4_request&X-Amz-Date=20221031T082443Z&X-Amz-Expires=900&X-Amz-Signature=f6f9bbacc995d2b0210a1d773e28af0e96adca6fcbaf22f471bcbb7b54a1361f&X-Amz-SignedHeaders=host%3Bx-amz-acl&x-amz-acl=public-read"
    private var queryMap = mutableMapOf<String, String>()

    @BeforeEach
    fun setUp() {
        queryMap += URL(fakeAwsUrl).splitQueryToMap()
    }

    //region Exception Test
    @Test
    @DisplayName("測試Not Throwable Exception")
    fun splitQueryNotExceptionTest() {
        Assertions.assertDoesNotThrow {
            URL(fakeAwsUrl).splitQueryToMap()
        }
    }

    @Test
    @DisplayName("測試URL Query Throwable Exception")
    fun splitQueryExceptionTest() {
        val exception = Assertions.assertThrows(NullPointerException::class.java) {
            URL("https://jie-storage-test.s3-accelerate.amazonaws.com").splitQueryToMap()
        }

        exception.message shouldBe "query must not be null"
    }
    //endregion

    @Test
    @DisplayName("測試分解URL elements")
    fun splitQueryElementsTest() {
        val urlElements = listOf(
            "host;x-amz-acl",
            "20221031T082443Z",
            "AWS4-HMAC-SHA256",
            "f6f9bbacc995d2b0210a1d773e28af0e96adca6fcbaf22f471bcbb7b54a1361f",
            "public-read",
            "900",
            "AKIA5VI5KUTXCBUY7K7G/20221031/us-east-2/s3/aws4_request"
        )

        queryMap.values.sorted() shouldBe urlElements.sorted()
    }

    @Test
    @DisplayName("測試分解URL Keys")
    fun splitQueryKeysTest() {
        val urlKeys = setOf(
            "X-Amz-Algorithm",
            "X-Amz-Credential",
            "X-Amz-Date",
            "X-Amz-Expires",
            "X-Amz-Signature",
            "X-Amz-SignedHeaders",
            "x-amz-acl"
        )

        queryMap.keys shouldBe urlKeys
    }
}