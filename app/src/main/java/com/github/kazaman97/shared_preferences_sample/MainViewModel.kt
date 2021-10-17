package com.github.kazaman97.shared_preferences_sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sharedPreferencesRepository: SharedPreferencesRepository
) : ViewModel() {
    companion object {
        private const val MEMO = "memo"
    }

    private val _memo = MutableLiveData<String>()
    val memo: LiveData<String> = _memo

    fun getMemo() {
        _memo.value = sharedPreferencesRepository.getString(MEMO)
    }

    fun setMemo(memo: String) {
        sharedPreferencesRepository.putString(MEMO, memo)
    }

    fun removeMemo() {
        sharedPreferencesRepository.removeString(MEMO)
    }
}
