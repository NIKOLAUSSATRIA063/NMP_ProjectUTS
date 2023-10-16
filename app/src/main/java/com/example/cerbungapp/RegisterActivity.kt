package com.example.cerbungapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cerbungapp.Global.accounts
import com.example.cerbungapp.databinding.ActivityLoginBinding
import com.example.cerbungapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnCreateAccount.setOnClickListener {

            val username = binding.txtCreateUsername.text.toString()
            val urlProfile = binding.txtUrl.text.toString()
            val password = binding.txtCreatePassword.text.toString()

            if (binding.txtUrl.text.toString() != "" && binding.txtCreatePassword.text.toString() != "" && binding.txtCreateUsername.text.toString() != ""){
                if (binding.txtCreatePassword.text.toString() != binding.txtCreateConfPassword.text.toString()){
                    Toast.makeText(this, "Password not same!", Toast.LENGTH_SHORT).show()
                } else{
                    addAccount(username, urlProfile, password)
                    Toast.makeText(this, "Account Added Successfully", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                }
            }else{
                Toast.makeText(this, "Please Fill the form", Toast.LENGTH_SHORT).show()
            }

        }



    }

    private fun addAccount(username:String, url_profile:String, password:String): Boolean{
        if (accounts.any { it.username == username || it.url_profile == url_profile }){
            return false
        }
        val newAccount = Account(username,url_profile, password)
        accounts.add(newAccount)
        return true
    }
}