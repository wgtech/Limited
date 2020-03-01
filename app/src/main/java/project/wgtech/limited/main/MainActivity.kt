package project.wgtech.limited.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import project.wgtech.limited.R

class MainActivity : AppCompatActivity() {
    private val TAG = this.javaClass.simpleName

    private lateinit var listener: OnBackPressedCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addOnBackPressedCallback(listener: OnBackPressedCallback?) {
        this.listener = listener!!
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}