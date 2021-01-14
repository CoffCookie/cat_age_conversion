package com.android.age_conversion

import android.util.Log

class DogCalc(var year_text: Int,var month_text:Int, var age:Int) {
    fun age_calc() {
        if (year_text == 0) {
            if (month_text < 12)
                when (month_text) {
                    1 -> age = 1
                    2 -> age = 3
                    in 3..5 -> age = 5
                    in 6..8 -> age = 9
                    in 9..11 -> age = 13
                }

            Log.println(Log.ASSERT, "age", age.toString())

        } else if (year_text == 1) {
            if (month_text < 6) {
                age = 16
            } else if (month_text >= 6 && month_text < 12) {
                age = 20
            }
        } else if (year_text == 2) {
            age = 24
        } else if (year_text >= 3) {
            age = 28 + (4 * (year_text - 3))
        }
    }
}