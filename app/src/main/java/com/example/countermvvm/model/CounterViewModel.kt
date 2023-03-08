package com.example.countermvvm.model

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countermvvm.model.CounterModel

class CounterViewModel(private val counterModel: CounterModel) : ViewModel() {

    private val counterLiveData = MutableLiveData<Int>()
    val counter: LiveData<Int>
        get() = counterLiveData

    private val _textColor = MutableLiveData<Int>()
    val textColor: LiveData<Int>
        get() = _textColor

    private val _showToast = MutableLiveData<String>()
    val showToast: LiveData<String>
        get() = _showToast

    init {
        counterLiveData.value = counterModel.getCounter()
        _textColor.value = Color.BLACK
    }

    fun increment() {
        counterModel.increment()
        counterLiveData.value = counterModel.getCounter()
        showToast()
        changeColor()
    }

    fun decrement() {
        counterModel.decrement()
        counterLiveData.value = counterModel.getCounter()
        changeColor()
    }

    private fun showToast() {
        if (counterModel.getCounter() == 10) _showToast.value = "Поздравляем!!"
    }

    private fun changeColor() {
        if (counterModel.getCounter() == 15) _textColor.value = Color.GREEN
        else _textColor.value = Color.BLACK
    }
}