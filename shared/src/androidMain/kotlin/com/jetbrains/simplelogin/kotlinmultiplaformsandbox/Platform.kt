package com.jetbrains.simplelogin.kotlinmultiplaformsandbox

class AndroidPlatform : Platform {
    override val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()