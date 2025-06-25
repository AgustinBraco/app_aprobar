package com.example.aprobar

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Locale

// GLOBAL
@SuppressLint("ConstantLocale")
val locale: Locale = Locale("es", "AR")
val today: LocalDate = LocalDate.now()
val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
val dayFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("EEEE", locale)

// Obtener lista con días hábiles siguientes
fun getNextDays(count: Int) : List<String> {
    val nextDays = mutableListOf<String>()
    var currentDate = today

    while (nextDays.size < count + 1) {
        val dayOfWeek = currentDate.dayOfWeek.value
        if(dayOfWeek in 1 .. 5) {
            nextDays.add(currentDate.format(dateFormatter))
        }
        currentDate = currentDate.plusDays(1)
    }
    return nextDays
}

// Obtener lista con días hábiles pasados
fun getPreviousDays(count: Int): List<String> {
    val previousDays = mutableListOf<String>()
    var currentDate = today

    while (previousDays.size < count + 1) {
        val dayOfWeek = currentDate.dayOfWeek.value
        if (dayOfWeek in 1..5) {
            previousDays.add(currentDate.format(dateFormatter))
        }
        currentDate = currentDate.minusDays(1)
    }
    return previousDays
}

// Obtener nombre del día
fun getDayName(dateString: String): String {
    val date = LocalDate.parse(dateString, dateFormatter)
    val dayName = date.format(dayFormatter).replaceFirstChar { it.uppercase(locale) }
    return dayName
}

// Alternar tamaño de u item
@SuppressLint("StaticFieldLeak")
var expandedView: View? = null
fun handleExpand(item: View) {
    item.setOnClickListener {
        // Validar estado de referencia
        if (expandedView != null && expandedView != item) {
            expandedView
                ?.animate()
                ?.scaleX(1f)
                ?.scaleY(1f)
                ?.setDuration(200)
                ?.start()
        }

        // Expandir item
        val isExpanded = item.scaleX > 1f
        val scale = if (isExpanded) 1f else 1.1f
        item.animate()
            .scaleX(scale)
            .scaleY(scale)
            .setDuration(200)
            .start()

        // Actualizar referencia
        expandedView = if (isExpanded) null else item
    }
}

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
    val expirationDate = LocalDate.parse(date, dateFormatter)
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

// PRESENTISMO
// Calcular porcentaje
fun getPercentage(present: Int, absent: Int): Int = when {
    present == 0 -> 0
    absent == 0 -> 100
    else -> (present * 100) / (present + absent)
}