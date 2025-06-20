package com.example.aprobar

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Crear última nota
        val lastGrade = GradesData("Adm. de Base de Datos", "Parcial", "1", "01/07/2025")

        // Obtener elementos
        val tvSubject: TextView = view.findViewById(R.id.grades_subject)
        val tvStatus: TextView = view.findViewById(R.id.grades_status)
        val tvType: TextView = view.findViewById(R.id.grades_type)
        val tvGrade: TextView = view.findViewById(R.id.grades_grade)
        val tvDate: TextView = view.findViewById(R.id.grades_date)

        // Asignar datos
        tvSubject.text = lastGrade.subject
        tvType.text = lastGrade.type
        tvGrade.text = lastGrade.grade
        tvDate.text = lastGrade.date

        setStatus(
            tvGrade.text.toString(),
            tvStatus,
            view.context
        )
    }
}