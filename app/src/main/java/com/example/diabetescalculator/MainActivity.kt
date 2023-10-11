package com.example.diabetescalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var edtEAG: EditText
    lateinit var edtA1C: EditText
    lateinit var rdoADAG: RadioButton
    lateinit var rdoDCCT: RadioButton
    lateinit var btnA1c: Button
    lateinit var btnEAG: Button
    lateinit var txtResults: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initApplication()
    }

    private fun initApplication() {
        edtEAG = findViewById(R.id.edtEAG)
        edtA1C = findViewById(R.id.edtA1C)
        rdoADAG = findViewById(R.id.rdoADAG)
        rdoDCCT = findViewById(R.id.rdoDCCT)
        btnA1c = findViewById(R.id.btnA1C)
        btnEAG = findViewById(R.id.btnEAG)
        txtResults = findViewById(R.id.txtResults)
    }

    fun calculateA1COnClick(v: View) {
        var eag: Double? = edtEAG.text.toString().toDoubleOrNull()
        var a1c: Double? = edtA1C.text.toString().toDoubleOrNull()
        var formula: Double

        if (eag == null) eag = 0.0
        if (a1c == null) a1c = 0.0
        //Use the radio button to determine the correct formula
//        ADAG Formula: A1C = (eAG + 46.7)/28.7
//        DCCT Formula: A1C = (eag + 77.3)/35.6
        if (rdoADAG.isChecked) {
            formula = (eag + 46.7) / 28.7
            txtResults.text = "%.1f".format(formula) + "\n(A1c using ADAG formula)"
        } else {
            formula = (eag + 77.3) / 35.6
            txtResults.text = "%.1f".format(formula) + "\n(A1c using DCCT formula)"
        }
    }

    fun calculateEAGOnClick(v: View) {
        var eag: Double? = edtEAG.text.toString().toDoubleOrNull()
        var a1c: Double? = edtA1C.text.toString().toDoubleOrNull()
        var formula: Double

        if (eag == null) eag = 0.0
        if (a1c == null) a1c = 0.0
        //Use the radio button to determine the correct formula
//        ADAG Formula: eAG = (28.7 * a1c) – 46.7
//        DCCT Formula: eAG = (a1c * 35.6) - 77.3
        if (rdoADAG.isChecked) {
            formula = (28.7 * a1c) - 46.7
            txtResults.text = "%.0f".format(formula) + "\n(eAG using ADAG formula)"
        } else {
            formula = (a1c * 35.6) - 77.3
            txtResults.text = "%.0f".format(formula) + "\n(eAG using DCCT formula)"
        }
    }
}