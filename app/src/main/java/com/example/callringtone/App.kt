package com.example.callringtone

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class App : Application() {

    companion object{
        const val NOTIFICATION = "notification"
    }

    override fun onCreate() {
        super.onCreate()
        createNotification()
    }

    private fun createNotification() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            var notyChannel: NotificationChannel = NotificationChannel(NOTIFICATION, "notification", NotificationManager.IMPORTANCE_DEFAULT)
            var notyMa: NotificationManager = getSystemService(NotificationManager::class.java)
            if(notyMa!=null){
                notyMa.createNotificationChannel(notyChannel)
            }
        }
    }

}