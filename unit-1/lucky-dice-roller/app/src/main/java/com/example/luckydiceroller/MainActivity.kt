package com.example.luckydiceroller

import android.os.Bundle
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // lucky number is hardcoded
        val rollButton1: Button = findViewById(R.id.rollButton)
        val rollButton2: Button = findViewById(R.id.rollButton2)
        // TODO luckyNumberInput isn't functional until I learn to update based on when Editable changes
        //val luckyNumberInput: EditText = findViewById(R.id.luckyNumberInput)
        val youWinText: TextView = findViewById(R.id.youWinText)
        // leave as var b/c at some point it'll be dependent on user input
        var luckyNumber = 4

        rollButton1.setOnClickListener { rollDice(luckyNumber, "dice one", youWinText) }
        rollButton2.setOnClickListener { rollDice(luckyNumber, "dice two", youWinText) }
        // TODO add in user input to update luckyNumber
        // TODO validate 1 <= luckyNumber <= 6
        //luckyNumberInput.addTextChangedListener()

        // roll a random number when the app loads to get a starting image
        rollDice(luckyNumber, "dice one", youWinText)
        rollDice(luckyNumber, "dice two", youWinText)
    }

    private fun rollDice(luckyNumber: Int, whichDice: String, youWinTextView: TextView) {
        // reset the winning text on a new roll
        youWinTextView.text = ""
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // determine which dice image to update based on which roll button selected
        val rollResult: ImageView = if (whichDice == "dice one") {
            findViewById(R.id.diceImage)
        } else {
            findViewById(R.id.diceImage2)
        }

        // when needs an else if returning a value (like assigning to val)
        // b/c can't return nil
        val drawableResource = when (diceRoll) {
            // deleted rollResult TextView. Will need these again to set the image
            luckyNumber -> R.drawable.dice_4
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // set the dice image and the description to the roll result
        rollResult.setImageResource(drawableResource)
        rollResult.contentDescription = diceRoll.toString()

        // display winning text if the dice roll matches your lucky number input
        if (diceRoll == luckyNumber) {
            youWinTextView.text = "YOU WON ON ${whichDice}!!".uppercase()
        }
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}