package com.awilab.network.ext

import java.io.UnsupportedEncodingException
import java.net.URL
import java.net.URLDecoder

@Throws(UnsupportedEncodingException::class)
fun URL.splitQueryToMap(): Map<String, String> {
	val queryPairs: MutableMap<String, String> = LinkedHashMap()
	val pairs = query.split("&").toTypedArray()

	for (pair in pairs) {
		val idx = pair.indexOf("=")
		val enc = "UTF-8"
		queryPairs[URLDecoder.decode(pair.substring(0, idx), enc)] = URLDecoder.decode(
			pair.substring(idx + 1), enc
		)
	}

	return queryPairs
}