package com.example.aprobar

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.Fragment


class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var sharedViewModel: SharedViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mockear datos
        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        sharedViewModel.loadPresenteeism()
        // Obtener el TextView
        val presenteeismPresent: TextView = view.findViewById(R.id.presenteeism_present)
        val presenteeismAbsent: TextView = view.findViewById(R.id.presenteeism_absent)
        val presenteeismPercentage: TextView = view.findViewById(R.id.presenteeism_percentage)

        // Observar los datos del ViewModel y sumar la cantidad de "present"
        sharedViewModel.presenteeismShared.observe(viewLifecycleOwner) { subjects ->
            val presents = subjects.sumOf { it.present }
            val absents = subjects.sumOf { it.absent }
            presenteeismPresent.text = "$presents"
            presenteeismAbsent.text = "$absents"
            val presenteeism = calculatePresenteeism(presents, absents)
            presenteeismPercentage.text = "$presenteeism%"
        }


        val previousDays = getPreviousDays(1)
        val nextDays = getNextDays(1)

        val lastGrade = GradesData("Base de Datos", "Parcial", "8.5", previousDays[1])
        val nextExpiration = ExpirationsData("Matemáticas", "Parcial", nextDays[0])
        val nextSchedule = ScheduleData(getDayName(nextDays[1]), nextDays[1], "PPII", "18:00 a 22:00", "meet.google.com/ppii")

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
        // Cronograma
        val scheduleDay: TextView = view.findViewById(R.id.schedule_day)
        val scheduleDate: TextView = view.findViewById(R.id.schedule_date)
        val scheduleSubject: TextView = view.findViewById(R.id.schedule_subject)
        val scheduleHour: TextView = view.findViewById(R.id.schedule_hour)
        val scheduleLink: TextView = view.findViewById(R.id.schedule_link)
        // Presentismo
        val presenteeismSubject: TextView = view.findViewById(R.id.presenteeism_subject)


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
        // Cronograma
        scheduleDay.text = nextSchedule.day
        scheduleDate.text = nextSchedule.date
        scheduleSubject.text = nextSchedule.subject
        scheduleHour.text = nextSchedule.hour
        scheduleLink.text = nextSchedule.link
        scheduleLink.autoLinkMask = Linkify.WEB_URLS
        scheduleLink.movementMethod = LinkMovementMethod.getInstance()
        // Presentismo
        presenteeismSubject.text = "Asistencia total"
    }

}