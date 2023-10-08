package com.example.cerbungapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.cerbungapp.databinding.ActivityCreateCerbungBinding
import com.example.cerbungapp.databinding.ActivityRegisterBinding

class CreateCerbungActivity : AppCompatActivity() {
    val genre = arrayOf("Horror", "Mistery", "Sci-Fi", "Romance")
    val CERBUNGTITLE = "title"
    val GENRESELECTED = "genre"
    val DESCRIPTION = "desc"
    val URL = "url"

    lateinit var adapter: ArrayAdapter<String>
    private lateinit var binding: ActivityCreateCerbungBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCerbungBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genre)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerGenre.setAdapter(adapter)


        binding.btnNextPage.setOnClickListener {
            var intent = Intent(this, CreateCerbungActivityP2::class.java)
            intent.putExtra(CERBUNGTITLE, binding.txtCreateTitle.text.toString())
            intent.putExtra(GENRESELECTED, binding.spinnerGenre.selectedItem.toString())
            intent.putExtra(DESCRIPTION, binding.txtShortDescription.text.toString())
            intent.putExtra(URL, binding.txtImgUrl.text.toString())
            startActivity(intent)
        }

    }
}