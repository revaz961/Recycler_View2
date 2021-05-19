package com.example.recycleapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecycleViewAdapter

    private val technologies = mutableListOf<TechnologyModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        setData()
        adapter = RecycleViewAdapter(technologies){
            val intent = Intent(this,FullDescriptionActivity::class.java)
            intent.putExtra("model",it)
            startActivity(intent)
        }
        binding.rvTechnologies.layoutManager = LinearLayoutManager(this)
        binding.rvTechnologies.adapter = adapter

    }

    private fun setData() {
        technologies.add(
            TechnologyModel(
                R.drawable.kotlin,
                getString(R.string.kotlin_title),
                getString(R.string.kotlin_description),
            )
        )
        technologies.add(
            TechnologyModel(
                R.drawable.java,
                getString(R.string.java_title),
                getString(R.string.java_description),
            )
        )
        technologies.add(
            TechnologyModel(
                R.drawable.c_sharp,
                getString(R.string.csharp_title),
                getString(R.string.csharp_description),
            )
        )
        technologies.add(
            TechnologyModel(
                R.drawable.cplus,
                getString(R.string.cplus_title),
                getString(R.string.cplus_description),
            )
        )
        technologies.add(
            TechnologyModel(
                R.drawable.nodejs,
                getString(R.string.js_title),
                getString(R.string.js_description),
            )
        )
        technologies.add(
            TechnologyModel(
                R.drawable.angular,
                getString(R.string.angular_title),
                getString(R.string.angular_description),
            )
        )
        technologies.add(
            TechnologyModel(
                R.drawable.react,
                getString(R.string.react_title),
                getString(R.string.react_description),
            )
        )
    }
}