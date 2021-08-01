package com.dt.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dt.test.Constants.SPLASH_DELAY
import kotlinx.android.synthetic.main.activity_main_splash.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Mock splash screen
        setContentView(R.layout.activity_main_splash)

        company.postDelayed( { setContentView(R.layout.activity_main) }, SPLASH_DELAY)
    }
}