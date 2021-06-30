package com.example.tic_tac_toe_191rdb051

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.Integer.MAX_VALUE
import java.lang.Integer.MIN_VALUE
import kotlin.random.Random

class GameActivity : AppCompatActivity()  {




    private var squares =  arrayOf<ArrayList<Button>>(arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf())
    private var player1Turn: Boolean = true
    private var firstPlayerScore: Int = 0
    private var ComputerScore: Int = 0
    private var Player1Name: String = ""
    private var Player2Name: String = ""
    private var PlayerSymbol = 'X'
    private var ComputerSybmol = '0'
    private var AITurn: Boolean = true
    private var PlayerTurn: Boolean = false






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)



        Player1Name = intent.getStringExtra("Player1Name").toString()
        Player2Name = intent.getStringExtra("Player2Name").toString()
        val comp: Boolean = intent.getBooleanExtra("comp",false)

        val Player1frame = findViewById<TextView>(R.id.FirstName)
        val Player2frame = findViewById<TextView>(R.id.SecondName)

        Player1frame.text = Player1Name
        Player2frame.text = Player2Name


        if(comp){
            for (i in 0..5) {
                for (j in 0..6) {
                    val square = resources.getIdentifier("square$i$j", "id", packageName)
                    squares[i].add(findViewById(square))
                }
            }
            val squaresCopy = arrayOf<ArrayList<Char>>(arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf())
            for(x in 0..5){
                for(z in 0..6){
                    squaresCopy[x].add((squares[x][z].text as String).first())
                }
            }
            PlayerSymbol = '0'
            ComputerSybmol = 'X'
            AI(squaresCopy)
        }

            for (i in 0..5) {
                for (j in 0..6) {
                    val square = resources.getIdentifier("square$i$j", "id", packageName)
                    squares[i].add(findViewById(square))


                    if (i > 0) {
                        squares[i][j].setOnClickListener {
                            if (squares[i][j].text == " " && squares[i - 1][j].text != " ") {
                                click(squares[i][j], true)
                            }
                        }
                    }
                    if (i == 0) {
                        squares[i][j].setOnClickListener {
                            click(squares[i][j], true)

                        }
                    }
                }
            }

    }



    private fun win():Boolean{
        val firstScore = findViewById<TextView>(R.id.FirstPlayerScore)
        val secondScore = findViewById<TextView>(R.id.ComputerScore)

        for(i in 0..2){
            for(j in 0..6){
                if(squares[i][j].text==squares[i+1][j].text && squares[i][j].text==squares[i+2][j].text && squares[i][j].text==squares[i+3][j].text &&
                    squares[i][j].text!=" "){
                    if(!player1Turn){
                        Toast.makeText(applicationContext, "$Player1Name wins", Toast.LENGTH_SHORT).show()
                        ++firstPlayerScore
                        firstScore.text = "$firstPlayerScore"

                    }
                    else{
                        Toast.makeText(applicationContext, "$Player2Name wins", Toast.LENGTH_SHORT).show()
                        ++ComputerScore
                        secondScore.text = "$ComputerScore"

                    }
                    return true}

            }
        }

        for(j in 0..3){
            for(i in 0..5){
                if(squares[i][j].text==squares[i][j+1].text && squares[i][j].text==squares[i][j+2].text && squares[i][j].text==squares[i][j+3].text &&
                    squares[i][j].text!=" "){
                    if(!player1Turn){
                        Toast.makeText(applicationContext, "$Player1Name wins", Toast.LENGTH_SHORT).show()
                        ++firstPlayerScore
                        firstScore.text = "$firstPlayerScore"

                    }
                    else{
                        Toast.makeText(applicationContext, "$Player2Name wins", Toast.LENGTH_SHORT).show()
                        ++ComputerScore
                        secondScore.text = "$ComputerScore"

                    }
                    return true

                }
            }
        }

        for(i in 0..2){
            for(j in 0..3){
                if(squares[i][j].text==squares[i+1][j+1].text && squares[i][j].text==squares[i+2][j+2].text && squares[i][j].text==squares[i+3][j+3].text &&
                    squares[i][j].text!= " "){
                    if(!player1Turn){
                        Toast.makeText(applicationContext, "$Player1Name wins", Toast.LENGTH_SHORT).show()
                        ++firstPlayerScore
                        firstScore.text = "$firstPlayerScore"

                    }
                    else{
                        Toast.makeText(applicationContext, "$Player2Name wins", Toast.LENGTH_SHORT).show()
                        ++ComputerScore
                        secondScore.text = "$ComputerScore"

                    }
                    return true
                }
            }
        }


        for(i in 0..2){
            for(j in 6 downTo 3){
                if(squares[i][j].text==squares[i+1][j-1].text && squares[i][j].text==squares[i+2][j-2].text && squares[i][j].text==squares[i+3][j-3].text &&
                    squares[i][j].text!=" "){
                    if(!player1Turn){
                        Toast.makeText(applicationContext, "$Player1Name wins", Toast.LENGTH_SHORT).show()
                        ++firstPlayerScore
                        firstScore.text = "$firstPlayerScore"

                    }
                    else{
                        Toast.makeText(applicationContext, "$Player2Name wins", Toast.LENGTH_SHORT).show()
                        ++ComputerScore
                        secondScore.text = "$ComputerScore"

                    }
                    return true
                }
            }
        }

        return false;
    }




    private fun AI_win(squaresCopy : Array<ArrayList<Char>>, Player_char : Char) : Boolean{
        for(i in 0..2){
            for(j in 0..6){
                if(squaresCopy[i][j]==squaresCopy[i+1][j] && squaresCopy[i][j]==squaresCopy[i+2][j] && squaresCopy[i][j]==squaresCopy[i+3][j] &&
                        squaresCopy[i][j]==Player_char){
                    return true}
            }
        }

        for(j in 0..3){
            for(i in 0..5){
                if(squaresCopy[i][j]==squaresCopy[i][j+1] && squaresCopy[i][j]==squaresCopy[i][j+2]  && squaresCopy[i][j]==squaresCopy[i][j+3] &&
                        squaresCopy[i][j]==Player_char){
                    return true
                }
            }
        }

        for(i in 0..2){
            for(j in 0..3){
                if(squaresCopy[i][j]==squaresCopy[i+1][j+1] && squaresCopy[i][j]==squaresCopy[i+2][j+2]&& squaresCopy[i][j]==squaresCopy[i+3][j+3] &&
                        squaresCopy[i][j]==Player_char){
                    return true
                }
            }
        }


        for(i in 0..2){
            for(j in 6 downTo 3){
                if(squaresCopy[i][j]==squaresCopy[i+1][j-1] && squaresCopy[i][j]==squaresCopy[i+2][j-2] && squaresCopy[i][j]==squaresCopy[i+3][j-3] &&
                        squaresCopy[i][j]==Player_char){
                    return true
                }
            }
        }

        return false;
    }


    private fun draw(squaresCopy: Array<ArrayList<Char>>) : Boolean{
        if(squaresCopy[5][0]!=' ' && squaresCopy[5][1]!=' ' && squaresCopy[5][2]!=' ' && squaresCopy[5][3]!=' ' && squaresCopy[5][4]!=' ' &&
                squaresCopy[5][5]!=' ' && squaresCopy[5][6]!=' '){
            Toast.makeText(applicationContext, "Draw", Toast.LENGTH_SHORT).show()
            return true
        }
        return false
    }

    private fun click(square: Button, play : Boolean){
        if(square.text!=" ")return
        if(player1Turn) {
            square.text = "X"
            player1Turn = false
        }
        else{
            square.text = "0"
            player1Turn = true
        }

        val squaresCopy = arrayOf<ArrayList<Char>>(arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf(), arrayListOf())
        for(i in 0..5){
            for(j in 0..6){
                squaresCopy[i].add((squares[i][j].text as String).first())
            }
        }

        if(win() || draw(squaresCopy)){
            for(i in 0..5){
                for(j in 0..6){
                    squares[i][j].text= " "
                    squaresCopy[i][j] = ' '

                }
            }

            player1Turn = true
            if(PlayerSymbol == '0'){
                AI(squaresCopy)
            }
        }
        if(PlayerSymbol=='X'){
            if(play && !player1Turn){
                AI(squaresCopy)}
        }else{
            if(play && player1Turn){
                AI(squaresCopy)
            }
        }

    }

    private fun minimax(squaresCopy : Array<ArrayList<Char>>, depth : Int, computerTurn : Boolean) : Int{


        if(AI_win(squaresCopy, PlayerSymbol))
            return -100
        if(AI_win(squaresCopy, ComputerSybmol))
            return 100
        if(draw(squaresCopy))
            return 0

        var bestScore = 0
        var score = 0

        if(depth <3){
            if(computerTurn){
                bestScore = Random.nextInt(1,99)

                for(i in 5 downTo 0){
                    for(j in 6 downTo 0){
                        if(squaresCopy[i][j] == ' '){
                            if(i>0 && squaresCopy[i-1][j] != ' '){
                                squaresCopy[i][j] = ComputerSybmol
                                score = minimax(squaresCopy, depth+1, PlayerTurn)
                                squaresCopy[i][j]= ' '

                            }
                            else if(i==0){
                                squaresCopy[i][j] = ComputerSybmol
                                score = minimax(squaresCopy, depth+1, PlayerTurn)
                                squaresCopy[i][j]= ' '

                            }
                        }
                        if(score>bestScore){
                            bestScore=score

                        }
                    }
                }


            }
            else{
                bestScore = Random.nextInt(-99,-1)
                for(i in 5 downTo 0){
                    for(j in 6 downTo 0){
                        if(squaresCopy[i][j] == ' '){
                            if(i>0 && squaresCopy[i-1][j] != ' '){
                                squaresCopy[i][j] = PlayerSymbol

                                score = minimax(squaresCopy, depth+1, AITurn)
                                squaresCopy[i][j]= ' '

                            }
                            else if(i==0){
                                squaresCopy[i][j] = PlayerSymbol

                                    score = minimax(squaresCopy, depth+1, AITurn)
                                squaresCopy[i][j]= ' '

                            }
                        }
                        if(score<bestScore){
                            bestScore=score

                        }
                    }
                }


            }

        }
        return bestScore

    }

    private fun AI(squaresCopy: Array<ArrayList<Char>>){

        var bestScore = Integer.MIN_VALUE
        var score = 0
        var coordI = 0
        var coordJ = 0

        for(i in 5 downTo 0){
            for(j in 6 downTo 0){
                if(squaresCopy[i][j] == ' '){
                    if(i>0 && squaresCopy[i-1][j] != ' '){
                        squaresCopy[i][j] = ComputerSybmol
                        score = minimax(squaresCopy, 0, PlayerTurn)
                        squaresCopy[i][j]= ' '
                        if(score>bestScore) {
                            bestScore = score
                            coordI = i
                            coordJ = j
                        }

                    }
                    else if(i==0){
                        squaresCopy[i][j] = ComputerSybmol
                        score = minimax(squaresCopy, 0, PlayerTurn)
                        squaresCopy[i][j]= ' '
                        if(score>bestScore) {
                            bestScore = score
                            coordI = i
                            coordJ = j
                        }


                    }
                }
            }
        }

        click(squares[coordI][coordJ], false)
    }

}

