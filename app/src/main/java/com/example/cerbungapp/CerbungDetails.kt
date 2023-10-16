package com.example.cerbungapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cerbungapp.Global.cerbungs
import com.example.cerbungapp.Global.judul
import com.example.cerbungapp.Global.paragrafs
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

        var title = cerbungs[id].title
        judul = title
        var url = cerbungs[id].url
        var genre = cerbungs[id].genre
        var author = cerbungs[id].author
        var date = cerbungs[id].lastUpdate
        var likes = cerbungs[id].like

        binding.titleTxt.setText(title.toString())

        val builder = Picasso.Builder(this)
        builder.listener { picasso, uri, exception ->
            exception.printStackTrace() }
        builder.build().load(url).into(binding.imagePoster)

        binding.genreChip.setText(genre.toString())
        binding.likeChip.setText(likes.toString() + " Likes")
        binding.countPrgChip.setText(countParagraf(title).toString() + " paragrafs")
        binding.authorsTxt.setText("by " + author.toString())
        binding.dateText.setText(date.toString())

        var statusRestric = cerbungs[id].restricted
        if(statusRestric.toString() == "Restricted"){
            binding.accessChip.setText(statusRestric.toString())
            binding.textNewParag.isVisible = false
            binding.btnSubmit.text = "Request"
        }else{
            binding.accessChip.isVisible =false
        }


        var user = Global.user
        binding.btnSubmit.setOnClickListener(){
            if(statusRestric.toString() != "Restricted"){
                var paragraf = binding.textNewParag.text.toString()
                if(paragraf != ""){
                    addParagraf(title, paragraf, user)
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra(USERNAME, user)
                    startActivity(intent)
                }
            }
        }
    }

    private fun addParagraf(titleCerbung:String, paragraf:String, user:String) {
        val newParag = Paragraf(titleCerbung, paragraf,user)
        paragrafs.add(newParag)
    }
    private fun countParagraf(titleCerbung:String): Int{
        var count = 0
        for(paragraf in paragrafs){
            if(titleCerbung == paragraf.namecerbung){
                count+=1
            }
        }
        return count
    }
}