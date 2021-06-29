package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnDone: Button = findViewById(R.id.btnDone)
        val tvNickName: EditText = findViewById(R.id.nickname_edit)
        val tvResult: TextView = findViewById(R.id.nickname_text)

        tvNickName.requestFocus()

        btnDone.setOnClickListener() {

            tvResult.text = tvNickName.text.toString()

            tvNickName.visibility = View.GONE
            btnDone.visibility = View.GONE
            tvResult.visibility = View.VISIBLE

            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)
        }

        tvResult.setOnClickListener() {
            tvNickName.visibility = View.VISIBLE
            btnDone.visibility = View.VISIBLE
            tvResult.visibility = View.GONE
            tvNickName.requestFocus()
            tvNickName.setSelection(tvNickName.length())

            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(tvNickName, 0)
        }


    }
}