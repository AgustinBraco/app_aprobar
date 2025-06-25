package com.example.aprobar

import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    // Mockear datos
    private val previousDays = getPreviousDays(20)
    private val nextDays = getNextDays(20)

    // Perfil
    val profile = ProfileData("Juan", "Perez", 23, "No especifica", "Desarrollo de Software")

    // Calificaciones
    val grades = listOf(
        GradesData("Base de datos", "Parcial", "8.5", previousDays[1]),
        GradesData("POO","Trabajo Práctico", "6", previousDays[2]),
        GradesData("PPI", "Parcial", "4.5", previousDays[5]),
        GradesData("Testing", "Parcial", "5.5", previousDays[9]),
        GradesData("Matemáticas","Final", "2", previousDays[11]),
        GradesData("Lógica","Trabajo Práctico", "7", previousDays[18]),
        GradesData("TICS","Trabajo Práctico", "6.5", previousDays[20])
    )

    // Vencimientos
    val expirations = listOf(
        ExpirationsData("Testing", "Parcial", nextDays[0]),
        ExpirationsData("Matemáticas", "Parcial", nextDays[1]),
        ExpirationsData("Base de Datos", "Trabajo Práctico", nextDays[3]),
        ExpirationsData("POO", "Parcial", nextDays[7]),
        ExpirationsData("PPII", "Final", nextDays[16]),
        ExpirationsData("Lógica", "Trabajo Práctico", previousDays[3]),
        ExpirationsData("Inglés", "Final", previousDays[7])
    )

    // Cronograma
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

    // Presentismo
    val presenteeism = listOf(
        PresenteeismData("PPI", 8, 2),
        PresenteeismData("Met. Pruebas de Sistemas", 14, 3),
        PresenteeismData("Base de Datos", 10, 1),
        PresenteeismData("Estadística y Probabilidad", 10, 0),
        PresenteeismData("POO", 14, 4),
        PresenteeismData("Taller de Comunicación", 0, 2)
    )
}