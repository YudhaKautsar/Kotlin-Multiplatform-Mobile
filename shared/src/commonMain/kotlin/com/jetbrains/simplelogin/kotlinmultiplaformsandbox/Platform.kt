package com.jetbrains.simplelogin.kotlinmultiplaformsandbox

interface Platform {
    val platform: String
}

expect fun getPlatform(): Platform