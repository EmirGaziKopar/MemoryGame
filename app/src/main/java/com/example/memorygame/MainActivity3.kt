package com.example.memorygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
    }


    fun hard(view: View){
        val intent = Intent(this,MainActivity2::class.java);
        finish()
        startActivity(intent)
    }

    fun medium(view: View){
        val intent = Intent(this,MainActivity::class.java);
        finish()
        startActivity(intent)
    }

    fun scores(view: View){
        val intent = Intent(this,MainActivity4::class.java);
        finish()
        startActivity(intent);
    }
}