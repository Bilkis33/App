package com.example.dyanimallyadd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dyanimallyadd.databinding.ActivityShowalldataBinding
import com.google.firebase.database.*

class Showalldata : AppCompatActivity() {
    private lateinit var binding: ActivityShowalldataBinding
    private lateinit var dbref: DatabaseReference
    private lateinit var recyclerview: RecyclerView
    private lateinit var userArrayList: ArrayList<LoginDataclass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowalldataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cardo.setOnClickListener{
            intent= Intent(this,more::class.java)
            startActivity(intent)
        }

        //BottomNavigationCode
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false

        recyclerview = findViewById(R.id.recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)

        userArrayList = arrayListOf<LoginDataclass>()
        getUserData()


        binding.button3.setOnClickListener {
            chooseThemeDialog()
        }

    }

    private fun getUserData() {
        dbref = FirebaseDatabase.getInstance().getReference("UserInformation")
        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (userSnapshot in snapshot.children) {
                        val user = userSnapshot.getValue(LoginDataclass::class.java)
                        userArrayList.add(user!!)
                    }
                    recyclerview.adapter = DataAdapter(userArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }


    private fun chooseThemeDialog() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Choose Your Theme")
        val styles = arrayOf("Light", "Dark", "System default")
        val checkedItem = 0

        builder.setSingleChoiceItems(styles, checkedItem) { dialog, which ->

                    when (which) {
                        0 -> {
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            delegate.applyDayNight()
                            dialog.dismiss()
                        }
                        1 -> {
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            delegate.applyDayNight()

                            dialog.dismiss()
                        }
                        2 -> {
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                            delegate.applyDayNight()
                            dialog.dismiss()
                        }

                    }
                }

                val dialog = builder.create()
                dialog.show()
            }

        }


