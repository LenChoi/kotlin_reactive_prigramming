package com.example.reactor.sec01;

import reactor.core.publisher.Mono;

import java.util.function.Consumer;

public class test {


    public static Consumer<Object> onNext(){
        return o -> System.out.println("Receive: " + o);
    }
}
