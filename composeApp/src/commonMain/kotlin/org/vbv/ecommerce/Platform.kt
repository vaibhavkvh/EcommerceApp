package org.vbv.ecommerce

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform