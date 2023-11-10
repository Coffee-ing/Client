package com.coffeeing.client.presentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.coffeeing.client.R
import com.coffeeing.client.databinding.ActivitySplashBinding
import com.coffeeing.client.presentation.home.HomeActivity
import com.coffeeing.client.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashActivity : BindingActivity<ActivitySplashBinding>(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        loadSplashScreen()
    }

    private fun loadSplashScreen() {
        lifecycleScope.launch {
            delay(1500L)
            moveToSign()
            finish()
        }
    }

    private fun moveToSign() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}