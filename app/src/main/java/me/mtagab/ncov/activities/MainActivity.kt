package me.mtagab.ncov.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import me.mtagab.ncov.R

class MainActivity : AppCompatActivity() {

    private val TAG = "health_main"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val google_login = findViewById<Button>(R.id.google_login)
        val facebook_login = findViewById<Button>(R.id.facebook_login)

        val register = findViewById<Button>(R.id.register)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        google_login.setOnClickListener{
            val intent = Intent(this, UserActivity::class.java)
            startActivity(intent)
        }

        facebook_login.setOnClickListener{
            val intent = Intent(this, UserActivity::class.java)
            startActivity(intent)
        }

        register.setOnClickListener{
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
