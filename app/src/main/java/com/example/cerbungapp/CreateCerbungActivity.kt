package com.example.cerbungapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.cerbungapp.databinding.ActivityCreateCerbungBinding
import com.example.cerbungapp.databinding.ActivityRegisterBinding

class CreateCerbungActivity : AppCompatActivity() {
    var USERNAME = "USER"
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

        var tempTitle = intent.getStringExtra(CERBUNGTITLE).toString()
        val tempGenreSelected = intent.getStringExtra(GENRESELECTED)
        val tempDescription = intent.getStringExtra(DESCRIPTION)
        val tempUrlImg = intent.getStringExtra(URL)
        val username = intent.getStringExtra(USERNAME).toString()

        if(tempTitle != "null"){
            binding.txtCreateTitle.setText(tempTitle)
            binding.txtShortDescription.setText(tempDescription.toString())
            binding.txtImgUrl.setText(tempUrlImg.toString())
            var indexGenre=0
            genre.forEachIndexed { index, nameGenre ->
                if(nameGenre== tempGenreSelected.toString()){
                    indexGenre = index
                }
            }
            binding.spinnerGenre.setSelection(indexGenre)
        }


        binding.btnNextPage.setOnClickListener {
            if (binding.txtCreateTitle.text.toString() == "" || binding.txtImgUrl.text.toString() == "" || binding.txtShortDescription.text.toString() == ""){
                Toast.makeText(this, "Please fill the textbox", Toast.LENGTH_SHORT).show()
            }
            else{
                var username = intent.getStringExtra(USERNAME).toString()

                var intent = Intent(this, CreateCerbungActivityP2::class.java)
                intent.putExtra(USERNAME, username)
                intent.putExtra(CERBUNGTITLE, binding.txtCreateTitle.text.toString())
                intent.putExtra(GENRESELECTED, binding.spinnerGenre.selectedItem.toString())
                intent.putExtra(DESCRIPTION, binding.txtShortDescription.text.toString())
                intent.putExtra(URL, binding.txtImgUrl.text.toString())
                startActivity(intent)
            }
        }

    }
}