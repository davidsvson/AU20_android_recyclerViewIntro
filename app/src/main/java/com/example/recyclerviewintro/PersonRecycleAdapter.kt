package com.example.recyclerviewintro

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonRecycleAdapter(val context : Context, val persons : List<Person>) :
    RecyclerView.Adapter<PersonRecycleAdapter.ViewHolder>() {

    // inflator används för att skapa en view utifrån en layout (XML)
    val layoutInflater = LayoutInflater.from(context)

    // hur många items finns det i vår datamängd?
    override fun getItemCount() : Int {
        return persons.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        // använder vår inflator för att skapa en ny view utifrån vår list_item-layout
        val itemView = layoutInflater.inflate(R.layout.list_item, parent, false)

        //skapa en ny viewHolder av vår egna klass Viewholder (skriven längre ner här)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //när en list_view ska visas tar vi rätt person från vår lista
        val person = persons[position]

        // sätter vi in personens uppgifter i vår view
        holder.textViewName.text = person.name
        holder.textViewAge.text = person.age.toString()
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        // när en ViewHolder skapas så letar vi reda på våra två textviews som
        // som finns i itemView
        val textViewName = itemView.findViewById<TextView>(R.id.textViewName)
        val textViewAge = itemView.findViewById<TextView>(R.id.textViewAge)
    }


}