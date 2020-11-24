package com.k31.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker.setOnClickListener { view ->
            clickDatePicker(view)
        }


    }

    fun clickDatePicker(view: View) {

        val myCal = Calendar.getInstance()
        val year = myCal.get(Calendar.YEAR)
        val month = myCal.get(Calendar.MONTH)
        val day = myCal.get(Calendar.DAY_OF_MONTH)

        val datepickerdialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->
                Toast.makeText(this,
                    "year chosen is $selectedYear, month chosen is ${selectedMonth+1}, day is $selectedDayOfMonth",
                    Toast.LENGTH_LONG).show()

                val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"

                tvSelectedDate.setText(selectedDate)

                val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val theDate = simpleDateFormat.parse(selectedDate)

                val selectedDateInMinute = theDate!!.time / 60000

                val currentDate = simpleDateFormat.parse(simpleDateFormat.format(System.currentTimeMillis()))

                val currentDateInMinute = currentDate!!.time / 60000

                val differenceInMinutes = currentDateInMinute - selectedDateInMinute

                tvSelectedDateInMinutes.setText(differenceInMinutes.toString())
            },
            year,
            month,
            day
        )

        datepickerdialog.datePicker.setMaxDate(Date().time - 86400000)
        datepickerdialog.show()
    }
}