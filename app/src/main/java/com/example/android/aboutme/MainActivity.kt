package com.example.android.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.android.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val name = MyName("Roman Glvac")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 'binging.myName' refers to the 'myName' variable defined in the layout file.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = name

        binding.doneButton.setOnClickListener{
            addNickname(it)
        }
    }

    private fun addNickname(view: View){

        binding.apply {
            nicknameEdit.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
            doneButton.visibility = View.GONE
            //nicknameText.text = binding.nicknameEdit.text
            name.nickname = nicknameEdit.text.toString()

            // Calling 'invalidateAll' ensures all references to members of data classes
            // are updated in the UI as well.
            invalidateAll()
        }

        // Automatically hiding keyboard after clicking 'Done' button.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}