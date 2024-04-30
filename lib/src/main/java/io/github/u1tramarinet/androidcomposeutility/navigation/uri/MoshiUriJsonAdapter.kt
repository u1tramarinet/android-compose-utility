package io.github.u1tramarinet.androidcomposeutility.navigation.uri

import android.net.Uri
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import io.github.u1tramarinet.androidcomposeutility.navigation.json.MoshiJsonParser
import java.io.IOException

class MoshiUriJsonAdapter : JsonAdapter<Uri>() {
    @Throws(IOException::class)
    override fun fromJson(reader: JsonReader): Uri? {
        return Uri.parse(reader.nextString())
    }

    @Throws(IOException::class)
    override fun toJson(writer: JsonWriter, value: Uri?) {
        writer.value(value.toString())
    }

    class Factory : MoshiJsonParser.Factory<Uri>() {
        override fun getType(): Class<Uri> = Uri::class.java
        override fun getAdapter(): JsonAdapter<Uri> = MoshiUriJsonAdapter()
    }
}
