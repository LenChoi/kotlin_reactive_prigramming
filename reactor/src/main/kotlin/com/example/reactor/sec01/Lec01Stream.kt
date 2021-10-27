package com.example.reactor.sec01

import java.util.stream.Stream

fun main() {
    val stream = Stream.of(1).map {
        Thread.sleep(1000)
        it * 2
    }
    stream.forEach { println(it) }
}
