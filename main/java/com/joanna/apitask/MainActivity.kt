package com.joanna.apitask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.joanna.apitask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var myItemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myItemAdapter = ItemAdapter(listOf())
        binding.recyclerApi.adapter = myItemAdapter

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.apply {
            getAllItems()
            items.observe(this@MainActivity, { item ->
                myItemAdapter.items = item
                myItemAdapter.notifyDataSetChanged()
            })

        }
        binding.button.setOnClickListener {
            val intent: Intent = Intent(this, StudentActivity::class.java)
            startActivity(intent)
        }
    }
}