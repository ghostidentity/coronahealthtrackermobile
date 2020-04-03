package me.mtagab.ncov.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.GoogleApiClient
import me.mtagab.ncov.R


class MainActivity : AppCompatActivity() {

    private val TAG = "health_main"
    private var googleApiClient: GoogleApiClient? = null
    private val RC_SIGN_IN = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var signInButton: SignInButton = findViewById(R.id.sign_in_button)
        val main = findViewById<TextView>(R.id.application_title)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        val gso =  GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestEmail()
                    .requestProfile()
                    .build()

        googleApiClient = GoogleApiClient.Builder(this)
            .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
            .build()

        signInButton.setOnClickListener {
            val intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient)
            startActivityForResult(intent, RC_SIGN_IN)
        }

        main.setOnClickListener {
            val intent = Intent(this, UserActivity::class.java)
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
