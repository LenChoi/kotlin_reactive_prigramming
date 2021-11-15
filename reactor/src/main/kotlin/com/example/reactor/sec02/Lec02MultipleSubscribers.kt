package com.example.reactor.sec02

import reactor.core.publisher.Flux

fun main() {
    val integerFlux = Flux.just(1, 2, 3, 4)

    val evenFlux = integerFlux.filter { it % 2 == 0 }

    integerFlux.subscribe {
        println("Sub 1 : $it")
    }

    evenFlux.subscribe {
        println("Sub 2 : $it")
    }
}