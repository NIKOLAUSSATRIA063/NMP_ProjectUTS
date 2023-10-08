package com.example.cerbungapp

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
            val email = binding.txtEmail.text.toString()
            val password = binding.txtCreatePassword.text.toString()

            if (binding.txtEmail.text.toString() != "" && binding.txtCreatePassword.text.toString() != "" && binding.txtCreateUsername.text.toString() != ""){
                if (binding.txtCreatePassword.text.toString() != binding.txtCreateConfPassword.text.toString()){
                    Toast.makeText(this, "Password not same!", Toast.LENGTH_SHORT).show()
                } else{
                    addAccount(username, email, password)
                    Toast.makeText(this, "Account Added Successfully", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Please Fill the form", Toast.LENGTH_SHORT).show()
            }

        }



    }

    private fun addAccount(username:String, email:String, password:String): Boolean{
        if (accounts.any { it.username == username || it.email == email }){
            return false
        }
        val newAccount = Account(username,email, password)
        accounts.add(newAccount)
        return true
    }
}