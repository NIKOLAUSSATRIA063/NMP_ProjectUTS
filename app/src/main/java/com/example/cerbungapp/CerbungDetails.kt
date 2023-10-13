package com.example.cerbungapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.cerbungapp.databinding.ActivityCerbungDetailsBinding
import com.example.cerbungapp.databinding.ActivityLoginBinding
import com.squareup.picasso.Picasso

class CerbungDetails : AppCompatActivity() {
    private lateinit var binding: ActivityCerbungDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_cerbung_details)
        super.onCreate(savedInstanceState)
        binding = ActivityCerbungDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var id = intent.getIntExtra("idcerbung", 0)

        var title = Global.cerbungs[id].title
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

    }
}