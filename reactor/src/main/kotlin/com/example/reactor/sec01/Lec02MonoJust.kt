package com.example.reactor.sec01

import reactor.core.publisher.Mono

fun main() {
    // publisher
    val mono = Mono.just(1)

    println("mono = ${mono}")

    mono.subscribe {
        println("Received = ${it}")
    }
}