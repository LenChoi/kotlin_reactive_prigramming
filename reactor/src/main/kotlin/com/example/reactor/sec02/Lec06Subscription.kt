package com.example.reactor.sec02

import com.example.reactor.courseutil.Util
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import reactor.core.publisher.Flux
import java.util.concurrent.atomic.AtomicReference

fun main() {
    val atomicReference = AtomicReference<Subscription>()

    Flux.range(1, 20)
        .log()
        .subscribeWith(object : Subscriber<Int> {
            override fun onSubscribe(subscription: Subscription) {
                println("Received Sub : $subscription")
                atomicReference.set(subscription)
            }

            override fun onNext(integer: Int) {
                println("onNext : $integer")
            }

            override fun onError(throwable: Throwable) {
                println("onError : ${throwable.message}")
            }

            override fun onComplete() {
                println("Completed")
            }
        })

    Util.sleepSeconds(3)
    atomicReference.get().request(3)
    Util.sleepSeconds(5)
    atomicReference.get().request(3)
    Util.sleepSeconds(5)
    println("going to cancel")
    atomicReference.get().cancel()
    Util.sleepSeconds(3)
    atomicReference.get().request(4)
}