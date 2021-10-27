package com.example.reactor.courseutil

import com.github.javafaker.Faker
import java.util.function.Consumer

class Util {
    companion object {
        val FAKER = Faker.instance()

        fun onNext(): Consumer<Any> {
            return Consumer { o: Any -> println("Receive: $o") }
        }

        fun onError(): Consumer<Throwable> {
            return Consumer { e: Throwable -> println("ERROR: ${e.message}") }
        }

        fun onComplete(): Runnable {
            return Runnable { print("Completed") }
        }

        fun faker(): Faker {
            return FAKER
        }
    }
}