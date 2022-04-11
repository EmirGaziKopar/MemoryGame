package com.example.memorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        val meyveler = listOf("300", "250", "246", "200", "186", "183", "152", "80", "32", "20")

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, meyveler)

        list_view.adapter = adapter

        list_view.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            val secilenMeyve = parent.getItemAtPosition(position) as String

            Toast.makeText( this, "Seçilen meyve: $secilenMeyve", Toast.LENGTH_SHORT).show()
        }
    }
}