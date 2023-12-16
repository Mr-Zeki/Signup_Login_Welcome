package com.example.singup_login_screens

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.singup_login_screens.databinding.ActivityMainBinding

class LoginPage : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferences = getSharedPreferences("Users", MODE_PRIVATE)


        binding.loginbtn.setOnClickListener{
            var registeredUserid  = preferences.getString("User_id","")
            var registeredUserPw = preferences.getString("User_pw","")
            var inputUserid = binding.Userinputid.text.toString()
            var inputUserpw = binding.Userinputpw.text.toString()

            if (inputUserid.isNotEmpty() && inputUserpw.isNotEmpty()){
                if (registeredUserid == inputUserid && registeredUserPw == inputUserpw){
                    intent = Intent(applicationContext,WelcomePage::class.java)
                    startActivity(intent)
                }
                else if (registeredUserid != inputUserid && registeredUserPw != inputUserpw){
                    Toast.makeText(applicationContext,"Kaydınız bulunmamaktadır,Lütfen kayıt olunuz",Toast.LENGTH_LONG).show()
                }
                else if (registeredUserid !=inputUserid ) {
                    Toast.makeText(applicationContext,"Kullanıcı adı hatalı",Toast.LENGTH_LONG).show()
                }
                else if (registeredUserPw != inputUserpw){
                    Toast.makeText(applicationContext,"Şifre hatalı", Toast.LENGTH_LONG).show()
                }
            }
            else if (inputUserid.isEmpty()){
                binding.Userinputid.error = "Boş Bırakılamaz"
            }
            else{
                binding.Userinputpw.error = "Boş Bırakılamaz"
            }
        }
        binding.siginpagebtn.setOnClickListener{
            intent = Intent(applicationContext,SignupPage::class.java)
            startActivity(intent)
        }
    }
}