package com.example.cerbungapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cerbungapp.Global.accounts
import com.example.cerbungapp.Global.cerbungs
import com.example.cerbungapp.Global.paragrafs
import com.example.cerbungapp.databinding.ActivityCreateCerbungBinding
import com.example.cerbungapp.databinding.ActivityCreateCerbungP3Binding
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.Date
import java.util.Locale

class CreateCerbungActivityP3 : AppCompatActivity() {
    private lateinit var binding: ActivityCreateCerbungP3Binding

    var USERNAME = "USER"
    var CERBUNGTITLE = "title"
    var GENRESELECTED = "genre"
    var DESCRIPTION = "desc"
    var URL = "url"
    var ACCESS = "access"
    var FIRSTPARAGRAPH = "paragraph"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCerbungP3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var author = intent.getStringExtra(USERNAME)
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
            intent.putExtra(CERBUNGTITLE, cerbugTitle.toString())
            intent.putExtra(DESCRIPTION, description.toString())
            intent.putExtra(GENRESELECTED, genreSelected.toString())
            intent.putExtra(URL, urlImg.toString())
            intent.putExtra(ACCESS, access.toString())
            intent.putExtra(FIRSTPARAGRAPH, firstParagraph.toString())
            intent.putExtra(USERNAME, author)
            startActivity(intent)
        }

        binding.checkBoxTerms.setOnClickListener {
            binding.btnPublish.setEnabled(false)
            if (binding.checkBoxTerms.isChecked()){
                binding.btnPublish.setEnabled(true)
            }
        }

        binding.btnPublish.setOnClickListener {
            try {

                var dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                var dateNow = dateFormat.format(Date())
                var newCerbung = Cerbung(cerbugTitle.toString(), author.toString(), access.toString(), dateNow, urlImg.toString(), description.toString() , genreSelected.toString(), 0)
                cerbungs.add(newCerbung)
                var newParagraf = Paragraf(cerbugTitle.toString(), firstParagraph.toString(), author.toString())
                paragrafs.add(newParagraf)
                Toast.makeText(this, "Tambah data berhasil", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, MainActivity::class.java)
                intent.putExtra(USERNAME, author)
                startActivity(intent)
            }
            catch (e: Exception) {
                Toast.makeText(this, "Gagal tambah, Error: " + e.message, Toast.LENGTH_LONG).show()
            }
        }




    }
}