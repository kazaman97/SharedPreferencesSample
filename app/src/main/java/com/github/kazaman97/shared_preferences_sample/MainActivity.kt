package com.github.kazaman97.shared_preferences_sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.github.kazaman97.shared_preferences_sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        private const val SP_KEY = "memo"
    }

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private val sharedPreferencesManager: SharedPreferencesManager
        get() = SharedPreferencesManager.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.textField.setText(sharedPreferencesManager.getString(SP_KEY))
        binding.save.setOnClickListener {
            sharedPreferencesManager.putString(SP_KEY, binding.textField.text.toString())
        }
        binding.delete.setOnClickListener {
            sharedPreferencesManager.removeString(SP_KEY)
            binding.textField.setText("")
        }
    }
}
