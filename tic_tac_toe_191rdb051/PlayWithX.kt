package com.example.tic_tac_toe_191rdb051

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class PlayWithX : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_with_x)
    }
    fun GoFirst(view : View){
        val PlayerName = findViewById<EditText>(R.id.PlayerName)
        val intent =  Intent(this, GameActivity::class.java)
        intent.putExtra("Player1Name",PlayerName.text.toString())
        intent.putExtra("Player2Name","Computer")
        intent.putExtra("comp", false)
        startActivity(intent)
    }
}