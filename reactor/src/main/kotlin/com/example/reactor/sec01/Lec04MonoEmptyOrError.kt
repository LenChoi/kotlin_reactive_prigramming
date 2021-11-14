package com.example.reactor.sec01

import com.example.reactor.courseutil.Util
import reactor.core.publisher.Mono

class Lec04MonoEmptyOrError {
    companion object {
        fun userRepository(userId: Int): Mono<String> {
            // 1
            if (userId == 1) {
                return Mono.just(Util.faker().name().firstName())
            } else if (userId == 2) {
                return Mono.empty()
            } else {
                return Mono.error(RuntimeException("Not in the allowed range"))
            }
        }
    }
}

fun main() {
    Lec04MonoEmptyOrError.userRepository(20)
        .subscribe(
            Util.onNext(),
            Util.onError(),
            Util.onComplete()
        )
}
