package com.killdog.jetpack

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProvider
import com.killdog.jetpack.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var binding:ActivityMainBinding
    lateinit var sp: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sp=getPreferences(Context.MODE_PRIVATE)
        val countReserved=sp.getInt("restart",0)
        viewModel= ViewModelProvider(this,MainViewModelFactory(countReserved)).get(MainViewModel::class.java)
        binding.button.setOnClickListener {//计时器
            viewModel.counter++
            refreshCounter()
        }
        binding.button2.setOnClickListener {
            viewModel.counter=0
            refreshCounter()
        }
        refreshCounter()
    }

    private fun refreshCounter(){
        binding.textView.text=viewModel.counter.toString()
    }

    override fun onPause() {
        super.onPause()
        sp.edit{
            putInt("count",viewModel.counter)
        }
    }
}