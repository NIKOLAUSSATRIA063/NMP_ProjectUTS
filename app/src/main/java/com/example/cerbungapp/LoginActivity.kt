package com.example.cerbungapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cerbungapp.Global.accounts
import com.example.cerbungapp.databinding.ActivityLoginBinding
import com.example.cerbungapp.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    val USERNAME = "USER"
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnSignIn.setOnClickListener {
            val username = binding.txtUsername.text.toString()
            val password = binding.txtPassword.text.toString()

            if (login(username, password)){
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(USERNAME, username)
                startActivity(intent)
                finish()
            } else{
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }


    }
    
    private fun login(username: String, password: String): Boolean{
        for (account in accounts){
            if (account.checkAccount(username, password)){
                return true
            }
        }
        return false
    }
    
}