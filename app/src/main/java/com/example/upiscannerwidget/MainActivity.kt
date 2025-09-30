package com.example.upiscannerwidget

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Launch scanner right away
        startActivity(Intent(this, ScannerActivity::class.java))

        // Close MainActivity so it doesn't stay in back stack
        finish()
    }
}
