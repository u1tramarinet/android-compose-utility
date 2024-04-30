package io.github.u1tramarinet.androidcomposeutility.navigation

import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.navigation.NavType
import io.github.u1tramarinet.androidcomposeutility.navigation.json.JsonParser
import io.github.u1tramarinet.androidcomposeutility.navigation.uri.MoshiUriJsonParser
import java.io.IOException

class UriNavType(private val parser: JsonParser<Uri> = MoshiUriJsonParser()) :
    NavType<Uri>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Uri? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, Uri::class.java)
        } else {
            @Suppress("DEPRECATION")
            bundle.getParcelable(key) as Uri?
        }
    }

    @Throws(IOException::class)
    override fun parseValue(value: String): Uri {
        return parser.fromJson(value)!!
    }

    override fun put(bundle: Bundle, key: String, value: Uri) {
        bundle.putParcelable(key, value)
    }

    companion object {
        fun encode(uri: Uri, jsonParser: JsonParser<Uri> = MoshiUriJsonParser()): String {
            return Uri.encode(jsonParser.toJson(uri))
        }
    }
}
