package com.example.cerbungapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cerbungapp.databinding.ActivityCreateCerbungBinding
import com.example.cerbungapp.databinding.ActivityCreateCerbungP3Binding

class CreateCerbungActivityP3 : AppCompatActivity() {
    private lateinit var binding: ActivityCreateCerbungP3Binding

    var CERBUNGTITLE = "title"
    var GENRESELECTED = "genre"
    var DESCRIPTION = "desc"
    var URL = "url"
    var ACCESS = ""
    var FIRSTPARAGRAPH = "paragraph"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCerbungP3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var cerbugTitle = intent.getStringExtra(CERBUNGTITLE)
        var genreSelected = intent.getStringExtra(GENRESELECTED)
        var description = intent.getStringExtra(DESCRIPTION)
        var urlImg = intent.getStringExtra(URL)
        var access = intent.getStringExtra(ACCESS)
        var firstParagraph = intent.getStringExtra(FIRSTPARAGRAPH)


        binding.txtNewTitle.setText(cerbugTitle)
        binding.txtNewGenre.setText(genreSelected)
        binding.txtNewAccess.setText(access)
        binding.txtNewDescription.setText(description)
        binding.txtNewFirstParagraph.setText(firstParagraph)

        binding.btnPrev2.setOnClickListener {
            var intent = Intent(this, CreateCerbungActivityP2::class.java)
            startActivity(intent)
        }

        binding.checkBoxTerms.setOnClickListener {
            binding.btnPublish.setEnabled(false)
            if (binding.checkBoxTerms.isChecked()){
                binding.btnPublish.setEnabled(true)
            }
        }


    }
}