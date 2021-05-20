package com.example.recycleapplication

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AccelerateInterpolator
import android.widget.ImageButton
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.forEach
import com.example.recycleapplication.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.root.forEach {
            if(it is ImageView){
                var param = it.layoutParams as ConstraintLayout.LayoutParams
                var angle = param.circleAngle as Float
                var animation = ValueAnimator.ofFloat(angle,angle+360)
                animation.addUpdateListener { anim ->
                    param.circleAngle = anim.animatedValue as Float
                    it.layoutParams = param
                }
                animation.duration = 3100
                animation.start()
            }
        }
        Handler().postDelayed({
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}