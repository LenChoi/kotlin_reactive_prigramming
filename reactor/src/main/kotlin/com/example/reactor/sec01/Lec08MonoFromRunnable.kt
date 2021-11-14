package com.example.reactor.sec01

import com.example.reactor.courseutil.Util
import com.example.reactor.courseutil.Util.Companion.onError
import com.example.reactor.courseutil.Util.Companion.onNext
import reactor.core.publisher.Mono

fun main() {
    Mono.fromRunnable<Any>(timeConsumingProcess())
        .subscribe(
            onNext(), onError(), Runnable {
                println("process in done. Sending emails...")
            }
        )
}

private fun timeConsumingProcess(): Runnable {
    return Runnable {
        Util.sleepSeconds(3)
        println("Operation completed")
    }
}