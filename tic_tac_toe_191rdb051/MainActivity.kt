package com.example.tic_tac_toe_191rdb051

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(applicationContext, "Greetings in Connect4!", Toast.LENGTH_SHORT).show()
    }

    fun PlayX(view : View){
        Intent(this, PlayWithX::class.java).also{
            startActivity(it)
        }
    }
    fun Play0(view : View){
        Intent(this, PlayWith0::class.java).also{
            startActivity(it)
        }
    }
}