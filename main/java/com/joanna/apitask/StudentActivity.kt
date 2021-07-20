package com.joanna.apitask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.joanna.apitask.databinding.ActivityStudentBinding

class StudentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStudentBinding
    private lateinit var myStudentAdapter: StudentAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myStudentAdapter = StudentAdapter(listOf())
        binding.recyclerView.adapter = myStudentAdapter

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.submit.setOnClickListener {

            binding.submit.setOnClickListener {
                var name: String = binding.insertedName.text.toString()
                var seat: Int = binding.insertedSeat.text.toString().toInt()
                var studentClass: String = binding.insertedClass.text.toString()

                var myPost = StudentModel(studentClass, name, seat)
                viewModel.pushPost(myPost)
            }

        }

    }


}
