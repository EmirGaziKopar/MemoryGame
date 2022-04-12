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

        textView9.text = "Score : "
        val context = this
        val db = DataBaseHelper(context)

        //read data
        var data = db.readData() //Burada eğer varsa veriler aktarıldı
        for(i in 0 until data.size){
            textView9.append((i+1).toString() +"."+ " Time : "+data.get(i).time+" Score : "+ data.get(i).score+"\n")
        }

        /*
        val meyveler = listOf("300", "250", "246", "200", "186", "183", "152", "80", "32", "20")

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, meyveler)

        list_view.adapter = adapter

        list_view.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            val secilenMeyve = parent.getItemAtPosition(position) as String

            Toast.makeText( this, "Seçilen meyve: $secilenMeyve", Toast.LENGTH_SHORT).show()
        }
        */


    }
}