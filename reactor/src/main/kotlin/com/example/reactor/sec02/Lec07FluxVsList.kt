package com.example.reactor.sec02

import com.example.reactor.courseutil.Util
import com.example.reactor.sec02.helper.NameGenerator

fun main() {
    NameGenerator.getNames(5)
        .subscribe(Util.onNext())
}