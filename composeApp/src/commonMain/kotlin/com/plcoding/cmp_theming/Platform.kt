package com.plcoding.cmp_theming

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform