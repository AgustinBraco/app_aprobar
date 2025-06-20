package com.example.aprobar

import android.annotation.SuppressLint
import android.content.Context
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

// GLOBAL
val today: LocalDate = LocalDate.now()
val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

// Obtener fecha pasada/futura en base a la fecha actual
fun getPastDate(days: Long): String = today.minusDays(days).format(formatter)
fun getFutureDate(days: Long): String = today.plusDays(days).format(formatter)

// CALIFICACIONES
// Definir texto y estilo en base a la nota obtenida
@SuppressLint("SetTextI18n")
fun setStatus(
    gradeText: String,
    view: TextView,
    context: Context
) {
    val grade = gradeText.toDoubleOrNull() ?: return
    when {
        grade >= 7 -> {
            view.text = "Promocionado"
            view.background = ContextCompat.getDrawable(context, R.drawable.style_rounded_green)
        }
        grade >= 6 -> {
            view.text = "Zona de promoción"
            view.background = ContextCompat.getDrawable(context, R.drawable.style_rounded_yellow)
        }
        grade >= 4 -> {
            view.text = "Regular"
            view.background = ContextCompat.getDrawable(context, R.drawable.style_rounded_orange)
        }
        else -> {
            view.text = "Libre"
            view.background = ContextCompat.getDrawable(context, R.drawable.style_rounded_red)
        }
    }
}

// VENCIMIENTOS
// Definir texto y estilo en base a la fecha actual
@SuppressLint("SetTextI18n")
fun setDays(
    date: String,
    view: TextView,
    context: Context
) {

    // Formatear fecha y calcular días restantes
    val expirationDate = LocalDate.parse(date, formatter)
    val days = ChronoUnit.DAYS.between(today, expirationDate)
    view.text = "$days días"

    when {
        days >= 16 -> {
            view.background = ContextCompat.getDrawable(context, R.drawable.style_rounded_green)
        }
        days >= 11 -> {
            view.background = ContextCompat.getDrawable(context, R.drawable.style_rounded_yellow)
        }
        days >= 6 -> {
            view.background = ContextCompat.getDrawable(context, R.drawable.style_rounded_orange)
        }
        days >= 2 -> {
            view.background = ContextCompat.getDrawable(context, R.drawable.style_rounded_orange)
        }
        days >= 1 -> {
            view.text = "Mañana"
            view.background = ContextCompat.getDrawable(context, R.drawable.style_rounded_red)
        }
        days >= 0 -> {
            view.text = "Hoy"
            view.background = ContextCompat.getDrawable(context, R.drawable.style_rounded_red)
        }
        else -> {
            view.text = "Vencido"
            view.setTextColor(ContextCompat.getColor(context, R.color.red))
            view.background = ContextCompat.getDrawable(context, R.drawable.style_rounded_grey)
        }
    }
}