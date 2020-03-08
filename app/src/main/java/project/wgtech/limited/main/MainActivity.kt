package project.wgtech.limited.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import project.wgtech.limited.R

class MainActivity : AppCompatActivity() {
    private val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() { // TODO : 앱 종료를 위한 연속 입력 유도 Toast 생성 (미확정)
        super.onBackPressed()
    }

}