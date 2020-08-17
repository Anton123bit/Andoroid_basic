package com.skillbox.android

import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val tag = "MainActivity"
    private val key = "key"

    private var state: FormState = FormState(false, "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DebugLogger.d(tag, "Активити создалось")

        edit_email.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkFieldsForEmptyValues()
            }
        })

        edit_password.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkFieldsForEmptyValues()
            }
        })

        checkBox.setOnClickListener {
            checkFieldsForEmptyValues()
        }

        progressButton.setOnClickListener {
            buttonTwo()
        }


        Log.v(tag, "Nothing")
        Log.d(tag, "Create activity")
        Log.i(tag, "All is ok")
        Log.e(tag, "Error")

        buttonANR.setOnClickListener {
            Thread.sleep(10000)
        }

    }

    override fun onPause() {
        super.onPause()
        DebugLogger.d(tag, "Активити находится на паузе")
    }

    override fun onDestroy() {
        super.onDestroy()
        DebugLogger.d(tag, "Активити больше нет R.I.P")
    }

    private fun checkFieldsForEmptyValues() {
        val b: Button = progressButton
        val s1: String = edit_email.text.toString()
        val s2: String = edit_password.text.toString()
        b.isEnabled = !(s1.isEmpty() || s2.isEmpty() || !checkBox.isChecked)
        state.valid = b.isEnabled

        if (s1.contains("@") && s2.length >= 5 && checkBox.isChecked) {
            textView.text = "Данные подтвержденны"
        } else {
            textView.text = "Данных нет, вы будете убиты через 5 секунд"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        state.message = textView.text.toString()
        outState.putParcelable(key, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getParcelable<FormState>(key)?.let {
            state = it
            textView.text = state.message
            progressButton.isEnabled = state.valid
        }
    }

    private fun buttonTwo() {

        edit_password.visibility = View.GONE
        edit_email.visibility = View.GONE
        checkBox.visibility = View.GONE
        progressLoader.visibility = View.VISIBLE
        progressButton.isEnabled = false


        Handler().postDelayed({
            textView.text = "Вы авторизовались"
            progressLoader.visibility = View.GONE
            edit_email.visibility = View.VISIBLE
            edit_password.visibility = View.VISIBLE
            checkBox.visibility = View.VISIBLE
            progressButton.isEnabled = true
            Toast.makeText(this, R.string.loginOn, Toast.LENGTH_SHORT).show()
        },2000)
    }

    object DebugLogger {
        fun d(tag: String, message: String) {
            Log.d(tag, message)
        }
    }

}


