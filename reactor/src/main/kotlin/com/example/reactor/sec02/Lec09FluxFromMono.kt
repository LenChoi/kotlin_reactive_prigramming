package com.example.reactor.sec02

import com.example.reactor.courseutil.Util
import reactor.core.publisher.Flux

fun main() {
//    val mono = Mono.just("a")
//
//    val flux = Flux.from(mono)
//
//    flux.subscribe(Util.onNext())

    Flux.range(1, 10)
        .filter { it > 3 }
        .next() // 1
        .subscribe(Util.onNext(), Util.onError(), Util.onComplete())
}