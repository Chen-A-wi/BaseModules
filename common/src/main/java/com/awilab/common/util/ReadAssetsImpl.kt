package com.awilab.common.util

import android.content.Context

class ReadAssetsImpl(
    private val context: Context
) : ReadAssets {
    override fun getFileFromAssets(fileName: String): String {
        val inputStream = context.assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)

        inputStream.read(buffer)
        inputStream.close()

        return String(buffer)
    }
}