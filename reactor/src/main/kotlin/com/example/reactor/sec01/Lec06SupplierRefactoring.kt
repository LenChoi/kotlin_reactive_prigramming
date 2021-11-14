package com.example.reactor.sec01

import com.example.reactor.courseutil.Util
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

fun main() {
    getName()
    val name = getName()
        .subscribeOn(Schedulers.boundedElastic())
        .block()
    println(name)
    getName()

    Util.sleepSeconds(4)
}

private fun getName(): Mono<String> {
    println("entered getName method")

    return Mono.fromSupplier {
        println("Generating name...")
        Util.sleepSeconds(3)
        Util.faker().name().fullName()
    }.map { it.uppercase() }
}