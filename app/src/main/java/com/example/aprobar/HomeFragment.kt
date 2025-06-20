package com.example.aprobar

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mockear datos
        val lastGrade = GradesData("Base de Datos", "Parcial", "8.5", getPastDate(1))
        val nextExpiration = ExpirationsData("Matemáticas", "Parcial", getFutureDate(0))

        // Obtener elementos
        // Calificaciones
        val gradesSubject: TextView = view.findViewById(R.id.grades_subject)
        val gradesStatus: TextView = view.findViewById(R.id.grades_status)
        val gradesType: TextView = view.findViewById(R.id.grades_type)
        val gradesGrade: TextView = view.findViewById(R.id.grades_grade)
        val gradesDate: TextView = view.findViewById(R.id.grades_date)
        // Vencimientos
        val expirationsSubject: TextView = view.findViewById(R.id.expirations_subject)
        val expirationsDays: TextView = view.findViewById(R.id.expirations_days)
        val expirationsType: TextView = view.findViewById(R.id.expirations_type)
        val expirationsDate: TextView = view.findViewById(R.id.expirations_date)

        // Asignar datos
        // Calificaciones
        gradesSubject.text = lastGrade.subject
        gradesType.text = lastGrade.type
        gradesGrade.text = lastGrade.grade
        gradesDate.text = lastGrade.date
        setStatus(
            gradesGrade.text.toString(),
            gradesStatus,
            view.context
        )
        // Vencimientos
        expirationsSubject.text = nextExpiration.subject
        expirationsType.text = nextExpiration.type
        expirationsDate.text = nextExpiration.date
        setDays(
            expirationsDate.text.toString(),
            expirationsDays,
            view.context
        )
    }
}