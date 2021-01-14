package com.android.age_conversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?):Boolean {
        menuInflater.inflate(R.menu.pet_select,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var imageView : ImageView = findViewById(R.id.imageView)
        val year_edit: EditText = findViewById(R.id.year_edit)
        val month_edit: EditText = findViewById(R.id.month_edit)
        val conv_button: Button = findViewById(R.id.conv_button)
        val pet_text: TextView = findViewById(R.id.pet_text)

        var year_text:Int = 0
        var month_text:Int = 0
        var age:Int = 0

        when(item?.itemId){
            R.id.home -> {

            }
            R.id.cat_text -> {
                imageView.setImageResource(R.drawable.cat)
                pet_text.text = "猫の年齢"

                conv_button.setOnClickListener{
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
            R.id.dog_text -> {
                imageView.setImageResource(R.drawable.dog)
                pet_text.text = "犬の年齢"

                conv_button.setOnClickListener {
                    if (year_edit.length() != 0) {
                        year_text = Integer.parseInt(year_edit.text.toString())
                    }
                    if (month_edit.length() != 0) {
                        month_text = Integer.parseInt(month_edit.text.toString())
                    }
                    val dog_calc = DogCalc(year_text,month_text,age)
                    dog_calc.age_calc()
                    age = dog_calc.age

                    val man_text: TextView = findViewById(R.id.man_edit)
                    man_text.text = age.toString()

                }

            }
        }
        return super.onOptionsItemSelected(item)
    }
}