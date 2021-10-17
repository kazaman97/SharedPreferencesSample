package com.github.kazaman97.shared_preferences_sample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.github.kazaman97.shared_preferences_sample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
    private val viewModel: MainViewModel by viewModels()
    private var memo: String = ""
        get() = binding.textField.text.toString()
        set(value) {
            binding.textField.setText(value)
            field = value
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.memo.observe(this) {
            memo = it
        }
        binding.save.setOnClickListener {
            viewModel.setMemo(memo)
        }
        binding.delete.setOnClickListener {
            viewModel.removeMemo()
            memo = ""
        }
        viewModel.getMemo()
    }
}
