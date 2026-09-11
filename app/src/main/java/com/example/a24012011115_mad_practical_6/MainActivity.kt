package com.example.a24012011115_mad_practical_6

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var alarmFrameAnimation: AnimationDrawable
    lateinit var ivAlarm: ImageView
    lateinit var heartPulseAnimation: AnimationDrawable
    lateinit var ivHeart: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        ivAlarm = findViewById(R.id.ivAlarm)

        ivAlarm.setBackgroundResource(R.drawable.alarm_frame_anim)
        alarmFrameAnimation = ivAlarm.background as AnimationDrawable

        ivHeart = findViewById(R.id.ivHeart)
        ivHeart.setBackgroundResource(R.drawable.ic_heart_outline)
        heartPulseAnimation = ivHeart.background as AnimationDrawable

        //android.util.Log.d("HeartAnim", "Loaded: $heartPulseAnimation")
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus){
            alarmFrameAnimation.start()
            heartPulseAnimation.start()
        }else{
            alarmFrameAnimation.stop()
            heartPulseAnimation.stop()

        }
    }
}