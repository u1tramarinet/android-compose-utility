package io.github.u1tramarinet.androidcomposeutility.navigation.json

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import java.lang.reflect.Type

abstract class MoshiJsonParser<T>(factory: Factory<T>) : JsonParser<T> {
    private val moshi: Moshi = Moshi.Builder().add(factory).build()
    private val adapter = moshi.adapter(factory.getType())

    override fun fromJson(json: String): T? {
        return adapter.fromJson(json)
    }

    override fun toJson(value: T?): String {
        return adapter.toJson(value)
    }

    abstract class Factory<T> : JsonAdapter.Factory {
        abstract fun getType(): Class<T>
        abstract fun getAdapter(): JsonAdapter<T>
        override fun create(
            type: Type,
            annotations: MutableSet<out Annotation>,
            moshi: Moshi
        ): JsonAdapter<*>? {
            if (type == getType()) {
                return getAdapter()
            }
            return null
        }
    }
}
