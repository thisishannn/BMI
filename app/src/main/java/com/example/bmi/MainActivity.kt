package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            calculateBMI()

        }

        buttonReset.setOnClickListener {
            reset()
        }

    }

    private fun reset(){
        editTextWeight.setText("")
        editTextHeight.setText("")
        textViewBMI.setText("BMI :")
    }



    private fun calculateBMI() {
        //perform input validation
        if (editTextWeight.text.toString().isEmpty()) {
            editTextWeight.setError(getString(R.string.input_error))
            return
        }

            if (editTextHeight.text.toString().isEmpty()) {
                editTextHeight.setError(getString(R.string.input_error))
                return
            }
            val weight = editTextWeight.text.toString().toFloat()
            val height = editTextHeight.text.toString().toFloat()
            val bmi = weight / (height / 100).pow(2)


            if (bmi < 18.5) {
                textViewBMI.text = String.format(
                    "%s %.2f (%s)",
                    getString(R.string.bmi), bmi, getString(R.string.under)
                )
                imageViewProfile.setImageResource(R.drawable.under)
            }

            if (bmi >18.5 && bmi <24.9) {
                textViewBMI.text = String.format(
                    "%s %.2f (%s)",
                    getString(R.string.bmi), bmi, getString(R.string.normal)
                )
                imageViewProfile.setImageResource(R.drawable.normal)
            }

            if (bmi > 25) {
                textViewBMI.text = String.format("%s %.2f (%s)",
                    getString(R.string.bmi), bmi, getString(R.string.over)
                )
                imageViewProfile.setImageResource(R.drawable.over)
            }

        }
    }




