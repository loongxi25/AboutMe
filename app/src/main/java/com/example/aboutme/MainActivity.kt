package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDone : Button = findViewById(R.id.btnDone)
        val nicknameEdit : TextView = findViewById(R.id.nicknameEdit)
        val tvNickname : TextView = findViewById(R.id.tvNickname)

        btnDone.setOnClickListener(){

            tvNickname.text = nicknameEdit.text

            btnDone.visibility = View.GONE
            nicknameEdit.visibility = View.GONE
            tvNickname.visibility = View.VISIBLE

            // Hide the keyboard.
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }

        tvNickname.setOnClickListener(){
            btnDone.visibility = View.VISIBLE
            nicknameEdit.visibility = View.VISIBLE
            tvNickname.visibility = View.GONE

            nicknameEdit.requestFocus()

            // Show the keyboard.
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(nicknameEdit, 0)
        }
    }
}