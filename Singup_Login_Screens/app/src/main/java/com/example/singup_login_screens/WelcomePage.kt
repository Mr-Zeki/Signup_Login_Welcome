package com.example.singup_login_screens

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.singup_login_screens.databinding.ActivityMainWelcomepageBinding
class WelcomePage : AppCompatActivity() {
    lateinit var preferencess: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainWelcomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferencess = getSharedPreferences("Users", MODE_PRIVATE)
        var registeredUserid = preferencess.getString("User_id","")
        binding.loggedUsr.text = (registeredUserid)!!.uppercase()

        binding.quitbtn.setOnClickListener{
            intent = Intent(applicationContext,LoginPage::class.java)
            startActivity(intent)
        }

    }
}