package com.example.reactor.sec02

import com.example.reactor.courseutil.Util
import reactor.core.publisher.Flux

fun main() {
    val flux = Flux.just(1, 2, 3, 4, "a", Util.faker().name().fullName())

    flux.subscribe(Util.onNext(), Util.onError(), Util.onComplete())
}