package com.test.launchmodeapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.test.launchmodeapplication.B
import com.test.launchmodeapplication.C
import com.test.launchmodeapplication.D
import com.test.launchmodeapplication.MainActivity

class A : AppCompatActivity() {

    private val tag = "A Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        Log.e(tag," intent onCreate $this")

        findViewById<Button>(R.id.btn_a).setOnClickListener {
            val intent = Intent(this, A::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_b).setOnClickListener {
            val intent = Intent(this, B::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_c).setOnClickListener {
            val intent = Intent(this, C::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_d).setOnClickListener {
            val intent = Intent(this, D::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_main).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.e(tag," intent onNewIntent $this")
        setIntent(intent)
    }
}