package com.example.aprobar

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtener elementos
        val btLogin: MaterialButton = findViewById(R.id.btLogin)
        val etDNI: EditText = findViewById(R.id.etDNI)

        btLogin.setOnClickListener {
            // Validar DNI
            if (etDNI.text.length != 8) {
                Toast.makeText(this, "El DNI debe ser de 8 dígitos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Cambiar pantalla y pasar el DNI
            val homeIntent = Intent(this, HomeActivity::class.java).apply {
                putExtra("dni", etDNI.text.toString())
            }
            startActivity(homeIntent)
        }
    }
}