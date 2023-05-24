package com.practice.fc_1_chapter9

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MediaPlayerService : Service() {
    private var mediaPlayer : MediaPlayer ?= null

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    // 서비스가 실행되고 -> onCreate()가 불린 이후에 실행됨
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action) {
            MEDIA_PLAYER_PLAY -> {
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(baseContext, R.raw.winner_winner_funky_chicken_dinner)
                }
                mediaPlayer?.start()
            }

            MEDIA_PLAYER_PAUSE -> {
                mediaPlayer?.pause()
            }

            MEDIA_PLAYER_STOP -> {
                mediaPlayer?.stop()

                // 메모리에서 MediaPlayer 해제
                mediaPlayer?.release()
                mediaPlayer = null

                // 서비스 종료
                stopSelf()
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }
}