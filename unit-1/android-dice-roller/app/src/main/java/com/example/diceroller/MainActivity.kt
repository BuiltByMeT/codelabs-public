package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and see the results
 * on the screen
 * TODO: add formatting to layout. Alignments don't match up flipping portrait to landscape and I don't know how to TODO .xml files
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val firstDice = Dice(6)
        //val secondDice = Dice(18)
        val rollButton: Button = findViewById(R.id.button)
        //var rollResultTextView : TextView = findViewById(R.id.rollResult)

        rollButton.setOnClickListener { rollDice() }
        /**
         * original code for rollButton.setOnClickListener working up to current
         * keeping for learning purposes
         * val toast = Toast.makeText(this,"Dice Rolled",Toast.LENGTH_SHORT)
         * toast.show()
         * rollResultTextView.text = theDice.roll()
         * rollDice()
         * }
         */
    }

    /**
     * Rolls the dice and updates the screen with the result
     */
    private fun rollDice() {
        val firstDice = Dice(6)
        val secondDice = Dice(18)
        val firstDiceRoll = firstDice.roll()
        val secondDiceRoll = secondDice.roll()
        val rollResult1TextView: TextView = findViewById(R.id.rollResult1)
        rollResult1TextView.text = firstDiceRoll.toString()
        val rollResult2TextView: TextView = findViewById(R.id.rollResult2)
        rollResult2TextView.text = secondDiceRoll.toString()
    }
}

/**
 * This class creates a dice and is home to the roll functionality
 */
class Dice(private val numSides: Int) {
    fun roll(): Int {
        // set @string/roll_result to result
        return (1..numSides).random()
    }
}