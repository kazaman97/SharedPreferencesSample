package com.github.kazaman97.shared_preferences_sample

import javax.inject.Inject

class SharedPreferencesRepository @Inject constructor(
    private val sharedPreferencesManager: SharedPreferencesManager
) {
    fun putString(
        key: String,
        value: String
    ) {
        sharedPreferencesManager.putString(key, value)
    }

    fun removeString(key: String) {
        sharedPreferencesManager.removeString(key)
    }

    fun getString(
        key: String,
        default: String = ""
    ): String = sharedPreferencesManager.getString(key)
}
