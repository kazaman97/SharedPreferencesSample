package com.github.kazaman97.shared_preferences_sample

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

    val memoText = MutableLiveData("")

    fun getMemo() {
        memoText.value = sharedPreferencesRepository.getString(MEMO)
    }

    fun putMemo() {
        sharedPreferencesRepository.putString(
            key = MEMO,
            value = memoText.value!!
        )
    }

    fun putEncryptedMemo() {
        sharedPreferencesRepository.putString(
            key = MEMO,
            value = memoText.value!!,
            isEncrypted = true
        )
    }

    fun removeMemo() {
        sharedPreferencesRepository.removeString(MEMO)
        memoText.value = ""
    }
}
