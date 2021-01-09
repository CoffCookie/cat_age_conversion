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
            var age : Int = 0

            if(year_edit.length() != 0) {
                year_text = Integer.parseInt(year_edit.text.toString())
            }
            if(month_edit.length() != 0){
                month_text = Integer.parseInt(month_edit.text.toString())
            }

            if(year_text == 0){
                if(month_text < 12 )
                    when(month_text){
                        1 -> age = 1
                        2 -> age = 3
                        in 3..5 -> age = 5
                        in 6..8 -> age = 9
                        in 9..11 -> age = 13
                    }

                Log.println(Log.ASSERT,"age",age.toString())

            }
            else if(year_text == 1){
                if(month_text < 6){
                    age = 17
                }
                else if(month_text >= 6 && month_text < 12){
                    age = 20
                }
            }
            else if(year_text == 2){
                age = 23
            }
            else if(year_text >= 3){
                age = 28 + (4*(year_text-3))
            }

            val man_text:TextView = findViewById(R.id.man_edit)
            man_text.text = age.toString()
        }
    }
}