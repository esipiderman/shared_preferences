package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE)

        binding.btnSubmit.setOnClickListener {
            val name = binding.edtName.text.toString()
            val email = binding.edtEmail.text.toString()

            val editor = sharedPreferences.edit()

            editor.putString("name", name)
            editor.putString("email", email)

            if (binding.radioMale.isChecked){

                editor.putBoolean("isMale", true)

            }else{

                editor.putBoolean("isMale", false)

            }

            editor.apply()
        }

        val name = sharedPreferences.getString("name", "")
        val email = sharedPreferences.getString("email", "")
        val isMale = sharedPreferences.getBoolean("isMale", true)

        binding.edtName.setText(name)
        binding.edtEmail.setText(email)
        if (isMale){
            binding.radioMale.isChecked = true
        }else{
            binding.radioFemale.isChecked = true
        }

    }
}