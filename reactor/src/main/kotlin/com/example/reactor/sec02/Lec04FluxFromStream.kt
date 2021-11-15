package com.example.reactor.sec02

import com.example.reactor.courseutil.Util
import reactor.core.publisher.Flux

fun main() {
    val list = mutableListOf(1, 2, 3, 4, 5)

    val interFlux = Flux.fromStream(list.stream())

    interFlux.subscribe(Util.onNext(), Util.onError(), Util.onComplete())
    interFlux.subscribe(Util.onNext(), Util.onError(), Util.onComplete())
}