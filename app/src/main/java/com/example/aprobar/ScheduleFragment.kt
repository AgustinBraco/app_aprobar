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
        val nextDays = getNextDays(6)

        val schedule = listOf(
            ScheduleData(getDayName(nextDays[0]), nextDays[0], "PPII", "18:00 a 22:00", "meet.google.com/ppii"),
            ScheduleData(getDayName(nextDays[1]), nextDays[1], "POO", "18:00 a 22:00", "meet.google.com/poo"),
            ScheduleData(getDayName(nextDays[2]), nextDays[2], "Testing", "18:00 a 20:00", "meet.google.com/testing"),
            ScheduleData(getDayName(nextDays[2]), nextDays[2], "Base de Datos", "20:00 a 22:00", "meet.google.com/bbdd"),
            ScheduleData(getDayName(nextDays[3]), nextDays[3], "Matemáticas", "18:00 a 22:00", "meet.google.com/matematicas"),
            ScheduleData(getDayName(nextDays[4]), nextDays[4], "Lógica", "18:00 a 20:00", "meet.google.com/logica"),
            ScheduleData(getDayName(nextDays[4]), nextDays[4], "Inglés", "20:00 a 22:00", "meet.google.com/ingles"),
            ScheduleData(getDayName(nextDays[5]), nextDays[5], "Estadística", "18:00 a 22:00", "meet.google.com/estadistica"),
            ScheduleData(getDayName(nextDays[6]), nextDays[6], "Backend", "18:00 a 22:00", "meet.google.com/backend")
        )

        // Configurar para mostrar lista de items
        val recyclerView = view.findViewById<RecyclerView>(R.id.schedule_recycler)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ScheduleAdapter(schedule)
    }
}