package com.example.cerbungapp

data class Account(val username:String, val url_profile:String, val password:String) {
//    fun checkPassword(inputPassword:String): Boolean{
//        return password == inputPassword
//    }

    fun checkAccount(inputUsername:String, inputPassword:String): Boolean{
        return (username == inputUsername) && (password == inputPassword)
    }
}
