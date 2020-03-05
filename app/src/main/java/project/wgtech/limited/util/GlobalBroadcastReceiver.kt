package project.wgtech.limited.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import project.wgtech.limited.R

class GlobalBroadcastReceiver : BroadcastReceiver() {
    private val TAG = this.javaClass.simpleName

    private lateinit var context: Context

    override fun onReceive(context: Context?, intent: Intent?) {
        this.context = context!!

        when (intent?.action) {
            Intent.ACTION_MY_PACKAGE_REPLACED
            -> Log.d(TAG, context.getString(R.string.log_app_update_completed))
        }
    }

}