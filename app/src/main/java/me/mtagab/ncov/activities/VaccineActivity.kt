package me.mtagab.ncov.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import me.mtagab.ncov.R

class VaccineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vaccine)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
    }
}
