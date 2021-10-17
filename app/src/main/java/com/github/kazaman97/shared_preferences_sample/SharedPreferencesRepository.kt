package com.github.kazaman97.shared_preferences_sample

import javax.inject.Inject

class SharedPreferencesRepository @Inject constructor(
    private val sharedPreferencesManager: SharedPreferencesManager
) {
    fun putString(
        key: String,
        value: String,
        isEncrypted: Boolean = false
    ) {
        sharedPreferencesManager.putString(
            key = key,
            value = value,
            isEncrypted = isEncrypted
        )
    }

    fun removeString(key: String) {
        sharedPreferencesManager.removeString(key)
    }

    fun getString(
        key: String,
        default: String = ""
    ): String = sharedPreferencesManager.getString(
        key = key,
        defaultValue = default
    )
}
