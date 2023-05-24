package com.practice.fc_1_chapter9

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.practice.fc_1_chapter9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var mediaPlayer : MediaPlayer ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.playButton.setOnClickListener {  mediaPlayerPlay() }
        binding.pauseButton.setOnClickListener {  mediaPlayerPause() }
        binding.stopButton.setOnClickListener {  mediaPlayerStop() }
    }

    private fun mediaPlayerPlay() {
        if(mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.winner_winner_funky_chicken_dinner).apply {
                isLooping = true
            }
        }
        mediaPlayer?.start()
    }

    private fun mediaPlayerPause() {
        mediaPlayer?.pause()
    }

    private fun mediaPlayerStop() {
        mediaPlayer?.stop()

        // 더이상 사용X -> 메모리에서 해제
        mediaPlayer?.release()
        mediaPlayer = null
    }
}