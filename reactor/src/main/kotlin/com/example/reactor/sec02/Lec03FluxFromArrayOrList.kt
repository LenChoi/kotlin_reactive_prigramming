package com.example.reactor.sec02

import com.example.reactor.courseutil.Util
import reactor.core.publisher.Flux

fun main() {
//    val strings = mutableListOf("a", "b", "c")
    val arr = arrayOf(2,5,7,8)

    Flux.fromArray(arr)
        .subscribe(Util.onNext())
}
