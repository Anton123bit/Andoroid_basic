package com.skillbox.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_deeplink.*

class DeeplinkActivity: AppCompatActivity(R.layout.activity_deeplink) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleIntentData()
    }

    //https://www.inter.it/en/news/team

    private fun handleIntentData() {
        intent.data?.lastPathSegment?.let {newsName ->
            teamNewsView.text = newsName
        }
    }
}