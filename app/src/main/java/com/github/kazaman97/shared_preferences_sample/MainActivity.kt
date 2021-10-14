package com.github.kazaman97.shared_preferences_sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.github.kazaman97.shared_preferences_sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.textField.setText(SharedPreferencesManager.instance.getString("memo"))
        binding.button.setOnClickListener {
            SharedPreferencesManager.instance.putString("memo", binding.textField.text.toString())
        }
    }
}
