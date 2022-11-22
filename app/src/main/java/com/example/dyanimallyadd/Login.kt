package com.example.dyanimallyadd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dyanimallyadd.databinding.ActivityLoginBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var datbase: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button2.setOnClickListener {
            intent=Intent(this,Showalldata::class.java)
            startActivity(intent)
        }



        binding.button2.setOnClickListener {
            val email = binding.editTextTextEmailAddress.text.toString()
            val passwordOfEmail = binding.editTextTextPassword.text.toString()
            val nameOfUser = binding.editTextTextPersonName2.text.toString()
            val age = binding.editTextTextPersonName3.text.toString()
            val dateOfBrith = binding.editTextDate.text.toString()


            datbase = FirebaseDatabase.getInstance().getReference("UserInformation")
            val user =
                LoginDataclass(email, passwordOfEmail, nameOfUser, age.toInt(), dateOfBrith.toInt())
            datbase.child(nameOfUser).setValue(user).addOnSuccessListener {
                binding.editTextTextEmailAddress.text.clear()
                binding.editTextTextPersonName2.text.clear()
                binding.editTextTextPersonName2.text.clear()
                binding.editTextTextPersonName3.text.clear()
                binding.editTextDate.text.clear()


                Toast.makeText(this, "Add Successfully", Toast.LENGTH_LONG).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Add Failured", Toast.LENGTH_LONG).show()
            }
        }
    }
}