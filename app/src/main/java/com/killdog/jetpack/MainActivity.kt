package com.killdog.jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.killdog.jetpack.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel= ViewModelProvider(this).get(MainViewModel::class.java)
        binding.button.setOnClickListener {
            viewModel.counter++
            refreshCounter()
        }
        refreshCounter()
    }
    private fun refreshCounter(){
        binding.textView.text=viewModel.counter.toString()
    }
}