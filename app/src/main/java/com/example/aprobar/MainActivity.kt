package com.example.aprobar

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cambiar activity al ingresar
        val btLogin = findViewById<MaterialButton>(R.id.btLogin)
        btLogin.setOnClickListener {
            val homeIntent = Intent(this, HomeActivity::class.java)
            startActivity(homeIntent)
        }
    }
}