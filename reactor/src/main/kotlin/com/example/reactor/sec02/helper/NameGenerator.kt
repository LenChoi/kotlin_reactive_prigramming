package com.example.reactor.sec02.helper

import com.example.reactor.courseutil.Util
import reactor.core.publisher.Flux

class NameGenerator {
    companion object {
//        fun getNames(count: Int): MutableList<String> {
//            val list:MutableList<String> = mutableListOf()
//
//            for (i in 1..count) {
//                list.add(getName())
//            }
//            return list
//        }

        fun getNames(count: Int): Flux<String> {
            return Flux.range(0, count)
                .map { getName() }
        }

        private fun getName(): String {
            Util.sleepSeconds(1)
            return Util.faker().name().fullName()
        }
    }
}