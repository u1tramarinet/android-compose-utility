package io.github.u1tramarinet.androidcomposeutility.navigation.uri

import android.net.Uri
import io.github.u1tramarinet.androidcomposeutility.navigation.json.MoshiJsonParser

class MoshiUriJsonParser : MoshiJsonParser<Uri>(MoshiUriJsonAdapter.Factory())