package com.example.cerbungapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cerbungapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var USERNAME = "USER"

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Toast.makeText(this, "Halo, " + intent.getStringExtra(USERNAME), Toast.LENGTH_SHORT).show()


        val lm: LinearLayoutManager = LinearLayoutManager(this)
        binding.recycleViewCerbung.layoutManager = lm
        binding.recycleViewCerbung.setHasFixedSize(true)
        binding.recycleViewCerbung.adapter = CerbungAdapter()


        binding.btnCreateCerbung.setOnClickListener {
            var username = intent.getStringExtra(USERNAME).toString()
            val intent = Intent(this, CreateCerbungActivity::class.java)
            intent.putExtra(USERNAME, username)
            startActivity(intent)
        }
    }
}