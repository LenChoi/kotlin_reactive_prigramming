package com.example.reactor.sec01

import com.github.javafaker.Faker

fun main() {
    for (i in 0..9) {
        println(Faker.instance().name().fullName())
    }
}