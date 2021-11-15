package com.example.reactor.sec02

import com.example.reactor.courseutil.Util
import reactor.core.publisher.Flux

fun main() {
    Flux.range(1, 10)
        .log()
        .map { Util.faker().name().fullName() }
        .log()
        .subscribe(Util.onNext())
}