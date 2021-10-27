package com.example.reactor.sec01

import com.example.reactor.courseutil.Util
import reactor.core.publisher.Mono

fun main() {
    // publisher
    val mono = Mono.just("ball")
        .map { it.length }
        .map { it / 1 }

    // 1
//    mono.subscribe()

    // 2
    mono.subscribe(Util.onNext(), Util.onError(), Util.onComplete())
}
