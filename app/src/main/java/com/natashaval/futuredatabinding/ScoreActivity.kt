package com.natashaval.futuredatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.natashaval.futuredatabinding.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val score = intent.getStringExtra("score")
        binding.scoreLabel.text = intent.getStringExtra("score")
        Log.d("ScoreActivity", "Score : $score")
    }
}