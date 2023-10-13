package com.example.cerbungapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cerbungapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val lm: LinearLayoutManager = LinearLayoutManager(this)
        binding.recycleViewCerbung.layoutManager = lm
        binding.recycleViewCerbung.setHasFixedSize(true)
        binding.recycleViewCerbung.adapter = CerbungAdapter()


        binding.btnCreateCerbung.setOnClickListener {
            val intent = Intent(this, CreateCerbungActivity::class.java)
            startActivity(intent)
        }


    }
}