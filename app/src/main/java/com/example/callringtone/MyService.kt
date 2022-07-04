package com.example.callringtone

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.os.IBinder


class MyService : Service() {

    private lateinit var player: MediaPlayer

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        player.start()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startRingTone()
        return START_NOT_STICKY
    }

    private fun startRingTone() {
        if(player==null){
            player = MediaPlayer.create(applicationContext, RingtoneManager.TYPE_RINGTONE)
        }
        player.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        player.stop()

    }
}