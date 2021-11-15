package com.example.reactor.sec02

import com.example.reactor.courseutil.Util
import reactor.core.publisher.Flux
import java.time.Duration

fun main() {
    Flux.interval(Duration.ofSeconds(1))
        .subscribe(Util.onNext())

    Util.sleepSeconds(5)
}