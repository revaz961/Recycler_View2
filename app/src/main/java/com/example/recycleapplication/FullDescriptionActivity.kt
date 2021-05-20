package com.example.recycleapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recycleapplication.databinding.ActivityFullDescriptionBinding

class FullDescriptionActivity : AppCompatActivity() {

    private lateinit var binding:ActivityFullDescriptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        val model:TechnologyModel = intent.extras?.getParcelable("model")!!
        setModel(model)
        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun setModel(model: TechnologyModel){
        if(model.image != null)
        binding.imgTechnology.setImageResource(model.image)
        else
            binding.tvTitle.text = model.title
        binding.tvDescription.text = model.description
    }
}