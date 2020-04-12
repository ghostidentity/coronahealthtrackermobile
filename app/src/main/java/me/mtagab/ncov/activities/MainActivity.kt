package me.mtagab.ncov.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import me.mtagab.ncov.R


class MainActivity : AppCompatActivity() {

    private val TAG = "health_main"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login = findViewById<Button>(R.id.login)
        val register = findViewById<Button>(R.id.register)

        val username = findViewById<TextView>(R.id.username)
        val password = findViewById<TextView>(R.id.password)

        login.setOnClickListener {
            val intent = Intent(this, UserActivity::class.java)
            startActivity(intent)
        }

        register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        Log.v(TAG, "Main activity created");
    }

    override fun onPause() {
        Log.v(TAG, "paused");
        super.onPause()
    }

    override fun onRestart() {
        Log.v(TAG, "restarted");
        super.onRestart()
    }

    override fun onResume() {
        Log.v(TAG, "resumed");
        super.onResume()
    }

    override fun onDestroy() {
        Log.v(TAG, "destroyed");
        super.onDestroy()
    }


}
