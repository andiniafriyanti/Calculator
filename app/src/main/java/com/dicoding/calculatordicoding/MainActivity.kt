package com.dicoding.calculatordicoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var edtPanjang: EditText
    private lateinit var edtLebar: EditText
    private lateinit var edtTinggi: EditText
    private lateinit var btnHitung: Button
    private lateinit var tvHasil: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtPanjang=findViewById(R.id.edt_panjang)
        edtLebar= findViewById(R.id.edt_lebar)
        edtTinggi= findViewById(R.id.edt_tinggi)
        btnHitung= findViewById(R.id.btn_hitung)
        tvHasil= findViewById(R.id.tv_hasil)

        btnHitung.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_hitung){
            val inputPanjang = edtPanjang.text.toString().trim()
            val inputLebar = edtLebar.text.toString().trim()
            val inputTinggi = edtTinggi.text.toString().trim()

            var isEmptyFields = false
            var isInvalidDouble = false

            if (inputPanjang.isEmpty()){
                isEmptyFields = true
                edtPanjang.error = "Field Tidak Boleh Kosong"
            }
            if (inputLebar.isEmpty()){
                isEmptyFields = true
                edtLebar.error = "Field Tidak Boleh Kosong"
            }
            if (inputTinggi.isEmpty()){
                isEmptyFields = true
                edtTinggi.error = "Field Tidak Boleh Kosong"
            }

            val panjang = toDouble(inputPanjang)
            val tinggi = toDouble(inputLebar)
            val lebar = toDouble(inputTinggi)

            if(panjang == null){
                isInvalidDouble = true
                edtPanjang.error = "Field ini harus berupa nomer yang valid"
            }

            if (lebar == null) {
                isInvalidDouble = true
                edtLebar.error = "Field ini harus berupa nomer yang valid"
            }
            if (tinggi == null) {
                isInvalidDouble = true
                edtTinggi.error = "Field ini harus berupa nomer yang valid"
            }

            if (!isEmptyFields && !isInvalidDouble) {
                val volume = panjang as Double * lebar as Double * tinggi as Double
                tvHasil.text = volume.toString()
            }

        }
    }
    private fun toDouble(str: String): Double?{
        return try {
            str.toDouble()
        } catch (e:NumberFormatException){
            null
        }
    }
}