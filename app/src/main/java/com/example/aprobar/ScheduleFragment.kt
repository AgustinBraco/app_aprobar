package com.example.aprobar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ScheduleFragment : Fragment(R.layout.fragment_schedule) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mockear datos
        val schedule = listOf(
            ScheduleData(getDayName(getFutureDate(0)), getFutureDate(0), "PPII", "18:00 a 22:00", "meet.google.com/ppii"),
            ScheduleData(getDayName(getFutureDate(1)), getFutureDate(1), "POO", "18:00 a 22:00", "meet.google.com/poo"),
            ScheduleData(getDayName(getFutureDate(2)), getFutureDate(2), "Testing", "18:00 a 20:00", "meet.google.com/testing"),
            ScheduleData(getDayName(getFutureDate(2)), getFutureDate(2), "Base de Datos", "20:00 a 22:00", "meet.google.com/bbdd"),
            ScheduleData(getDayName(getFutureDate(3)), getFutureDate(3), "Matemáticas", "18:00 a 22:00", "meet.google.com/matematicas"),
            ScheduleData(getDayName(getFutureDate(4)), getFutureDate(4), "Lógica", "18:00 a 20:00", "meet.google.com/logica"),
            ScheduleData(getDayName(getFutureDate(4)), getFutureDate(4), "Inglés", "20:00 a 22:00", "meet.google.com/ingles"),
            ScheduleData(getDayName(getFutureDate(5)), getFutureDate(5), "Estadística", "18:00 a 22:00", "meet.google.com/estadistica"),
            ScheduleData(getDayName(getFutureDate(6)), getFutureDate(6), "Backend", "18:00 a 22:00", "meet.google.com/backend")
        )

        // Configurar para mostrar lista de items
        val recyclerView = view.findViewById<RecyclerView>(R.id.schedule_recycler)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ScheduleAdapter(schedule)
    }
}