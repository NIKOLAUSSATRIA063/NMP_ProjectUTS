package com.example.cerbungapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cerbungapp.databinding.ActivityCerbungDetailsBinding
import com.example.cerbungapp.databinding.ActivityLoginBinding
import com.squareup.picasso.Picasso

class CerbungDetails : AppCompatActivity() {
    private lateinit var binding: ActivityCerbungDetailsBinding
    var USERNAME = "USER"
    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_cerbung_details)
        super.onCreate(savedInstanceState)
        binding = ActivityCerbungDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lm: LinearLayoutManager = LinearLayoutManager(this)
        binding.recyclerViewDetailsCerbung.layoutManager = lm
        binding.recyclerViewDetailsCerbung.setHasFixedSize(true)
        binding.recyclerViewDetailsCerbung.adapter = CerbungDetailsAdapter()

        var id = intent.getIntExtra("idcerbung", 0)

        var title = Global.cerbungs[id].title
        Global.judul = title
        var url = Global.cerbungs[id].url
        var genre = Global.cerbungs[id].genre
        var author = Global.cerbungs[id].author
        var date = Global.cerbungs[id].lastUpdate

        binding.titleTxt.setText(title.toString())

        val builder = Picasso.Builder(this)
        builder.listener { picasso, uri, exception ->
            exception.printStackTrace() }
        builder.build().load(url).into(binding.imagePoster)

        binding.genreChip.setText(genre.toString())
        binding.authorsTxt.setText("by " + author.toString())
        binding.dateText.setText(date.toString())

        var user = Global.user
        binding.btnSubmit.setOnClickListener(){
            var paragraf = binding.textNewParag.text.toString()
            if(paragraf != ""){
                addParagraf(title, paragraf, user)
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(USERNAME, user)
                startActivity(intent)
            }
        }
    }

    private fun addParagraf(titleCerbung:String, paragraf:String, user:String) {
        val newParag = Paragraf(titleCerbung, paragraf,user)
        Global.paragrafs.add(newParag)
    }
}