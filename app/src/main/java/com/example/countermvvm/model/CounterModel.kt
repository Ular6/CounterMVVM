package com.example.countermvvm.model

class CounterModel {
    private var count = 0

    fun increment() {
        count++
    }

    fun decrement() {
        count--
    }

    fun getCounter() : Int {
        return count
    }
}