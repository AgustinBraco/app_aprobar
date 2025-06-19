package com.example.aprobar

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lastGrade = GradesData("Adm. de Base de Datos", "Parcial", "1", "01/07/2025")

        val tvSubject = view.findViewById<TextView>(R.id.grades_subject)
        val tvStatus = view.findViewById<TextView>(R.id.grades_status)
        val tvType = view.findViewById<TextView>(R.id.grades_type)
        val tvGrade = view.findViewById<TextView>(R.id.grades_grade)
        val tvDate = view.findViewById<TextView>(R.id.grades_date)

        tvSubject.text = lastGrade.subject

        val gradeNum = lastGrade.grade.trim().toDouble()
        when {
            gradeNum >= 7 -> {
                tvStatus.text = "Promocionado"
                tvStatus.background = ContextCompat.getDrawable(view.context, R.drawable.style_rounded_green)
            }
            gradeNum >= 6 -> {
                tvStatus.text = "Zona de promoción"
                tvStatus.background = ContextCompat.getDrawable(view.context, R.drawable.style_rounded_yellow)
            }
            gradeNum >= 4 -> {
                tvStatus.text = "Regular"
                tvStatus.background = ContextCompat.getDrawable(view.context, R.drawable.style_rounded_orange)
            }
            else -> {
                tvStatus.text = "Libre"
                tvStatus.background = ContextCompat.getDrawable(view.context, R.drawable.style_rounded_red)
            }
        }

        tvType.text = lastGrade.type
        tvGrade.text = lastGrade.grade
        tvDate.text = lastGrade.date

    }
}