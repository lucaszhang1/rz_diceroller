package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var diceImage1: ImageView
    lateinit var diceImage2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)
        val outcometext: TextView = findViewById(R.id.outcome)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            //Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()

            var total = 0
            for (i in 0..999) {
                var dice1 = rollDice(diceImage1)
                var dice2 = rollDice(diceImage2)
                if (dice1 == dice2) ++total
            }
            outcometext.text = "${total.toDouble()/10}%"
        }
    }

    private fun rollDice(imageView: ImageView): Int {
        val randomInt = Random().nextInt(6) + 1
        imageView.setImageResource(
            when (randomInt) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
        )
        return randomInt
    }
}