package io.github.u1tramarinet.androidcomposeutility.navigation.json

import java.io.IOException

interface JsonParser<T> {
    @Throws(IOException::class)
    fun fromJson(json: String): T?
    fun toJson(value: T?): String
}
