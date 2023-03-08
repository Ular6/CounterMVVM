package com.example.countermvvm.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.countermvvm.databinding.ActivityMainBinding
import com.example.countermvvm.model.CounterModel
import com.example.countermvvm.model.CounterViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val counterModel = CounterModel()
        viewModel = CounterViewModel(counterModel)

        binding.apply {
            viewModel.counter.observe(this@MainActivity) { counter ->
                binding.tvCounter.text = counter.toString()
            }
            viewModel.textColor.observe(this@MainActivity) { color ->
                binding.tvCounter.setTextColor(color)
            }
            viewModel.showToast.observe(this@MainActivity) { message ->
                Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
            }

            binding.btnIncrement.setOnClickListener {
                viewModel.increment()
            }
            binding.btnDecrement.setOnClickListener {
                viewModel.decrement()
            }
        }
    }
}