package com.example.reactor.sec01

import com.example.reactor.courseutil.Util
import com.example.reactor.sec01.Lec05MonoFromSupplier.Companion.getName
import reactor.core.publisher.Mono
import java.util.concurrent.Callable
import java.util.function.Supplier

class Lec05MonoFromSupplier {
    companion object {
        fun getName(): String {
            println("Generating name..")
            return Util.faker().name().fullName()
        }
    }
}

fun main() {
    // use just only when you have data already
//    val mono = Mono.just(Lec05MonoFromSupplier.getName())

    val stringSupplier = Supplier { getName() }
    val mono = Mono.fromSupplier { stringSupplier }
    mono.subscribe { Util.onNext() }

    val stringCallable = Callable { getName() }
    Mono.fromCallable(stringCallable)
        .subscribe(Util.onNext())
}