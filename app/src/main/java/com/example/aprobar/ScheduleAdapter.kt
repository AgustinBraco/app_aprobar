package com.example.aprobar

import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ScheduleAdapter(private val schedule: List<ScheduleData>) : RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {

    // Definir elementos a usar en cada item
    class ScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val scheduleDay: TextView = itemView.findViewById(R.id.schedule_day)
        val scheduleDate: TextView = itemView.findViewById(R.id.schedule_date)
        val scheduleSubject: TextView = itemView.findViewById(R.id.schedule_subject)
        val scheduleHour: TextView = itemView.findViewById(R.id.schedule_hour)
        val scheduleLink: TextView = itemView.findViewById(R.id.schedule_link)
    }

    // Crear e inflar item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_schedule, parent, false)
        return ScheduleViewHolder(view)
    }

    // Asignar datos a cada ítem
    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val course = schedule[position]
        holder.scheduleDay.text = course.day
        holder.scheduleDate.text = course.date
        holder.scheduleSubject.text = course.subject
        holder.scheduleHour.text = course.hour
        holder.scheduleLink.text = course.link
        holder.scheduleLink.autoLinkMask = Linkify.WEB_URLS
        holder.scheduleLink.movementMethod = LinkMovementMethod.getInstance()
    }

    // Definir cantidad de items
    override fun getItemCount(): Int = schedule.size
}

