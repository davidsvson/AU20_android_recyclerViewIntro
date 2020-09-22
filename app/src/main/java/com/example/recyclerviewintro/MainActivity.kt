package com.example.recyclerviewintro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var persons = listOf<Person>(Person("David", 42),
                                Person("Susan", 36),
                                Person("Lois", 7),
                                Person("Laura", 10))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        //skapa ett adapter-object från vår adapter-klass, skicka med vår lista
        val adapter = PersonRecycleAdapter(this, persons)

        // koppla ihop vår adapter med recyclerview:n
        recyclerView.adapter = adapter

    }
}