package com.android.age_conversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val year_edit: EditText = findViewById(R.id.year_edit)
        val month_edit: EditText = findViewById(R.id.month_edit)
        val conv_button: Button = findViewById(R.id.conv_button)

        conv_button.setOnClickListener{
            var year_text:Int = 0
            var month_text:Int = 0
            var age:Int = 0

            if (year_edit.length() != 0) {
                year_text = Integer.parseInt(year_edit.text.toString())
            }
            if (month_edit.length() != 0) {
                month_text = Integer.parseInt(month_edit.text.toString())
            }

            val cat_calc = CatCalc(year_text,month_text,age)
            cat_calc.age_calc()
            age = cat_calc.age

            val man_text: TextView = findViewById(R.id.man_edit)
            man_text.text = age.toString()

        }
    }
}