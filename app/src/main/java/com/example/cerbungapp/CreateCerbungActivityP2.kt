package com.example.cerbungapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cerbungapp.databinding.ActivityCreateCerbungBinding
import com.example.cerbungapp.databinding.ActivityCreateCerbungP2Binding

class CreateCerbungActivityP2 : AppCompatActivity() {
    private lateinit var binding: ActivityCreateCerbungP2Binding

    var USERNAME = "USER"
    var CERBUNGTITLE = "title"
    var GENRESELECTED = "genre"
    var DESCRIPTION = "desc"
    var URL = "url"
    var ACCESS = "access"
    var FIRSTPARAGRAPH = "paragraph"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCerbungP2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(USERNAME).toString()
        val tempTitle = intent.getStringExtra(CERBUNGTITLE)
        val tempGenreSelected = intent.getStringExtra(GENRESELECTED)
        val tempDescription = intent.getStringExtra(DESCRIPTION)
        val tempUrlImg = intent.getStringExtra(URL)

        binding.btnPrev.setOnClickListener {
            var intent = Intent(this, CreateCerbungActivity::class.java)
            startActivity(intent)
        }

        binding.btnNextPage2.setOnClickListener {

            var userAccess = ""
            if (binding.radioPublic.isChecked){
                userAccess = "PUBLIC"
            } else if (binding.radioRestricted.isChecked) {
                userAccess = "Restricted"
            }


            var intent = Intent(this, CreateCerbungActivityP3::class.java)
            intent.putExtra(USERNAME, username)
            intent.putExtra(CERBUNGTITLE, tempTitle.toString())
            intent.putExtra(GENRESELECTED, tempGenreSelected.toString())
            intent.putExtra(DESCRIPTION, tempDescription.toString())
            intent.putExtra(URL, tempUrlImg.toString())
            intent.putExtra(CERBUNGTITLE, tempTitle.toString())
            intent.putExtra(ACCESS,userAccess.toString())
            intent.putExtra(FIRSTPARAGRAPH, binding.txtFirstParagraph.text.toString())

            startActivity(intent)
        }
    }
}