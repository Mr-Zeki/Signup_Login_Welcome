package com.example.singup_login_screens

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.singup_login_screens.databinding.ActivityMainSignupBinding

class SignupPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainSignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signupbtn.setOnClickListener{
            var userid = binding.newUserinputid.text.toString()
            var userpw = binding.newUserinputpw.text.toString()
            var userpw2 = binding.newPwagain.text.toString()
            var min_length : Int = 4
            var max_length : Int = 16
            var sharedPreferences = getSharedPreferences("Users", MODE_PRIVATE)
            var editor = sharedPreferences.edit()

            if (userid.isNotEmpty() && userpw.isNotEmpty() && userpw2.isNotEmpty()){

                if (userid.length < min_length){
                    Toast.makeText(applicationContext,"Kullanıcı Adı En Az 4 Karakter İçermelidir",Toast.LENGTH_LONG).show()
                    binding.newUserinputid.text.clear()
                }
               else if (userid.length > max_length){
                    Toast.makeText(applicationContext,"Kullanıcı Adı 16 Karakterden Uzun Olamaz",Toast.LENGTH_LONG).show()
                    binding.newUserinputid.text.clear()
                }
               else if (userpw.length < min_length){
                    Toast.makeText(applicationContext,"Şifre En Az 4 Karakter İçermelidir",Toast.LENGTH_LONG).show()
                    binding.newUserinputpw.text.clear()
                }
               else if (userpw.length > max_length){
                    Toast.makeText(applicationContext,"Şifre 16 Karakterden Uzun Olamaz",Toast.LENGTH_LONG).show()
                    binding.newUserinputpw.text.clear()
                }
               else if (userid == userpw){
                   Toast.makeText(applicationContext, "Kullanıcı Adı ve Şifre Aynı Olamaz",Toast.LENGTH_LONG).show()
                    binding.newUserinputid.text.clear()
                    binding.newUserinputpw.text.clear()
                }
                else if (userpw2 != userpw){
                    Toast.makeText(applicationContext, "Şifreler Eşleşmiyor",Toast.LENGTH_LONG).show()
                    binding.newUserinputpw.text.clear()
                    binding.newPwagain.text.clear()
                }
               else if (userpw == userpw2){
                    editor.putString("User_id", "$userid")
                    editor.putString("User_pw", "$userpw")
                    editor.apply()
                    Toast.makeText(applicationContext,"Kayıt Başarılı", Toast.LENGTH_LONG).show()
                    binding.newUserinputid.text.clear()
                    binding.newUserinputpw.text.clear()
                    binding.newPwagain.text.clear()
                }
            }
            else if (userid.isEmpty()){
                binding.newUserinputid.error = "Boş Bırakılamaz"
            }
            else if (userpw.isEmpty()){
                binding.newUserinputpw.error = "Boş Bırakılamaz"
            }
            else if (userpw2.isEmpty()){
                binding.newPwagain.error = "Boş Bırakılamaz"
            }
        }

        binding.loginscreenbtn.setOnClickListener{
            intent = Intent(applicationContext,LoginPage::class.java)
            startActivity(intent)
        }

    }
}