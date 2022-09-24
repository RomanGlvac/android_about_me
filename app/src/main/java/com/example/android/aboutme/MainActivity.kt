package com.example.android.aboutme

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
        findViewById<Button>(R.id.doneButton).setOnClickListener {
            // 'it' in this context refers to the button.
            addNickname(it)
        }
    }

    private fun addNickname(view: View){
        val nicknameEditText = findViewById<EditText>(R.id.nicknameEdit)
        val nicknameTextView = findViewById<TextView>(R.id.nicknameText)
        val doneButton = findViewById<Button>(R.id.doneButton)

        nicknameEditText.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE
        doneButton.visibility = View.GONE

        nicknameTextView.text = nicknameEditText.text

        // Automatically hiding keyboard after clicking 'Done' button.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}