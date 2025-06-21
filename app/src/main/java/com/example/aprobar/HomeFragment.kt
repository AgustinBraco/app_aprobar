package com.example.aprobar

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels


class HomeFragment : Fragment(R.layout.fragment_home) {
    private val sharedViewModel: SharedViewModel by activityViewModels()

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // CALIFICACIONES
        // Obtener elementos
        val gradesSubject: TextView = view.findViewById(R.id.grades_subject)
        val gradesStatus: TextView = view.findViewById(R.id.grades_status)
        val gradesType: TextView = view.findViewById(R.id.grades_type)
        val gradesGrade: TextView = view.findViewById(R.id.grades_grade)
        val gradesDate: TextView = view.findViewById(R.id.grades_date)

        // Obtener datos mockeados
        val lastGrade = sharedViewModel.grades[0]

        // Asignar datos
        gradesSubject.text = lastGrade.subject
        gradesType.text = lastGrade.type
        gradesGrade.text = lastGrade.grade
        gradesDate.text = lastGrade.date
        setStatus(lastGrade.grade, gradesStatus, view.context)

        // VENCIMIENTOS
        // Obtener elementos
        val expirationsSubject: TextView = view.findViewById(R.id.expirations_subject)
        val expirationsDays: TextView = view.findViewById(R.id.expirations_days)
        val expirationsType: TextView = view.findViewById(R.id.expirations_type)
        val expirationsDate: TextView = view.findViewById(R.id.expirations_date)

        // Obtener datos mockeados
        val nextExpiration = sharedViewModel.expirations[0]

        // Asignar datos
        expirationsSubject.text = nextExpiration.subject
        expirationsType.text = nextExpiration.type
        expirationsDate.text = nextExpiration.date
        setDays(nextExpiration.date, expirationsDays, view.context)

        // CRONOGRAMA
        // Obtener elementos
        val scheduleDay: TextView = view.findViewById(R.id.schedule_day)
        val scheduleDate: TextView = view.findViewById(R.id.schedule_date)
        val scheduleSubject: TextView = view.findViewById(R.id.schedule_subject)
        val scheduleHour: TextView = view.findViewById(R.id.schedule_hour)
        val scheduleLink: TextView = view.findViewById(R.id.schedule_link)

        // Obtener datos mockeados
        val nextSchedule = sharedViewModel.schedule[0]

        // Asignar datos
        scheduleDay.text = nextSchedule.day
        scheduleDate.text = nextSchedule.date
        scheduleSubject.text = nextSchedule.subject
        scheduleHour.text = nextSchedule.hour
        scheduleLink.text = nextSchedule.link
        scheduleLink.autoLinkMask = Linkify.WEB_URLS
        scheduleLink.movementMethod = LinkMovementMethod.getInstance()

        // PRESENTISMO
        // Obtener elementos
        val presenteeismSubject: TextView = view.findViewById(R.id.presenteeism_subject)
        val presenteeismPresent: TextView = view.findViewById(R.id.presenteeism_present)
        val presenteeismAbsent: TextView = view.findViewById(R.id.presenteeism_absent)
        val presenteeismPercentage: TextView = view.findViewById(R.id.presenteeism_percentage)

        // Obtener datos mockeados
        val presenteeism = sharedViewModel.presenteeism
        val totalPresents = presenteeism.sumOf { it.present }
        val totalAbsents = presenteeism.sumOf { it.absent }
        val totalPercentage = getPercentage(totalPresents, totalAbsents)

        // Asignar datos
        presenteeismSubject.text = "Asistencia total"
        presenteeismPresent.text = "$totalPresents"
        presenteeismAbsent.text = "$totalAbsents"
        presenteeismPercentage.text = "$totalPercentage%"
    }
}