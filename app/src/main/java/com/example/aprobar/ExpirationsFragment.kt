package com.example.aprobar

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ExpirationsFragment : Fragment(R.layout.fragment_expirations) {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Generador de fecha en base a fecha actual
        val date = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

        // Mockear datos
        val expirations = listOf(
            ExpirationsData("Testing", "Parcial", date.plusDays(0).format(formatter)),
            ExpirationsData("Matemáticas", "Parcial", date.plusDays(1).format(formatter)),
            ExpirationsData("Base de Datos", "Trabajo Práctico", date.plusDays(6).format(formatter)),
            ExpirationsData("POO", "Parcial", date.plusDays(12).format(formatter)),
            ExpirationsData("PPII", "Final", date.plusDays(20).format(formatter)),
            ExpirationsData("Lógica", "Trabajo Práctico", date.minusDays(3).format(formatter)),
            ExpirationsData("Inglés", "Final", date.minusDays(7).format(formatter))
        )

        // Configurar para mostrar lista de items
        val recyclerView = view.findViewById<RecyclerView>(R.id.expirations_recycler)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ExpirationsAdapter(expirations)
    }
}