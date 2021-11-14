package com.example.reactor.sec01

import com.example.reactor.courseutil.Util
import reactor.core.publisher.Mono
import java.util.concurrent.CompletableFuture

fun main() {
    Mono.fromFuture(getName())
        .subscribe(Util.onNext())

    Util.sleepSeconds(1)
}

private fun getName(): CompletableFuture<String> {
    return CompletableFuture.supplyAsync{
        Util.faker().name().fullName()
    }
}