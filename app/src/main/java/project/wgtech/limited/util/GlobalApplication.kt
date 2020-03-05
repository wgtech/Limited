package project.wgtech.limited.util

import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.IntentFilter

class GlobalApplication : Application() {
    private val TAG = this.javaClass.simpleName

    private lateinit var intentFilter: IntentFilter
    private lateinit var receiver: GlobalBroadcastReceiver

    companion object {
        lateinit var instance: GlobalApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_MY_PACKAGE_REPLACED)

        receiver = GlobalBroadcastReceiver()
        registerReceiver(receiver, intentFilter)
    }

    fun context(): Context = applicationContext

    override fun onTerminate() {
        unregisterReceiver(receiver)
        super.onTerminate()
    }





}