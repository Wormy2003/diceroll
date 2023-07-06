package com.example.diceroll

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.diceroll.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rollDice()

        binding.rollBtn.setOnClickListener {
            rollDice()
            zvuk()
        }

    }

    private fun rollDice() {
        val dice = Dice(6)
        val dice2 = Dice(6)
        val kubilRoll = dice.roll()
        val kubilRoll2 = dice2.roll()

        val diceImage = binding.imageView
        val diceImage2 = binding.imageView2

        when (kubilRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice1)
            2 -> diceImage.setImageResource(R.drawable.dice2)
            3 -> diceImage.setImageResource(R.drawable.dice3)
            4 -> diceImage.setImageResource(R.drawable.dice4)
            5 -> diceImage.setImageResource(R.drawable.dice5)
            6 -> diceImage.setImageResource(R.drawable.dice6)
        }

        when (kubilRoll2) {
            1 -> diceImage2.setImageResource(R.drawable.dice1)
            2 -> diceImage2.setImageResource(R.drawable.dice2)
            3 -> diceImage2.setImageResource(R.drawable.dice3)
            4 -> diceImage2.setImageResource(R.drawable.dice4)
            5 -> diceImage2.setImageResource(R.drawable.dice5)
            6 -> diceImage2.setImageResource(R.drawable.dice6)
        }


    }


    fun zvuk() {
        MediaPlayer.create(this, R.raw.dices).start()
    }


    class Dice(val numSides:Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}