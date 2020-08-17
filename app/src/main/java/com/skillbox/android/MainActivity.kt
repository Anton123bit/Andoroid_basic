package com.skillbox.android

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edit_email.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkEmail()
            }
        })

        edit_password.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkEmail()
            }
        })


        progressButton.setOnClickListener {

            val messageText = edit_email.text.toString()

            startActivity(SecondActivity.getIntent(this, messageText))
            finish()
            }

    }

    private fun checkEmail() {
        val emailAddress = edit_email.text.toString()
        val password = edit_password.text.toString()
        val button: Button = progressButton
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()

        button.isEnabled = (isEmailValid && password.isNotEmpty() && checkBox.isChecked)
    }

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

}


