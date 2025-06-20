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

class GradesFragment : Fragment(R.layout.fragment_grades) {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Generador de fecha en base a fecha actual
        val date = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

        // Mockear datos
        val grades = listOf(
            GradesData("Base de Datos", "Parcial", "8.5", date.minusDays(1).format(formatter)),
            GradesData("POO","Trabajo Práctico", "6", date.minusDays(2).format(formatter)),
            GradesData("PPI", "Parcial", "4.5", date.minusDays(5).format(formatter)),
            GradesData("Testing", "Parcial", "5.5", date.minusDays(9).format(formatter)),
            GradesData("Matemáticas","Final", "2", date.minusDays(11).format(formatter)),
            GradesData("Lógica","Trabajo Práctico", "7", date.minusDays(18).format(formatter)),
            GradesData("TICS","Trabajo Práctico", "6.5", date.minusDays(20).format(formatter))
        )

        // Configurar para mostrar lista de items
        val recyclerView = view.findViewById<RecyclerView>(R.id.grades_recycler)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = GradesAdapter(grades)
    }
}