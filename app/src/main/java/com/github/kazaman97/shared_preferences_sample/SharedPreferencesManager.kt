package com.github.kazaman97.shared_preferences_sample

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPreferencesManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    companion object {
        private const val SP_NAME = "sample_preferences"
    }

    private val sharedPreferences
        get() = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)

    fun putString(
        key: String,
        value: String
    ) {
        sharedPreferences.edit()
            .putString(key, value)
            .apply()
    }

    fun removeString(key: String) {
        sharedPreferences.edit()
            .remove(key)
            .apply()
    }

    fun getString(
        key: String,
        defaultValue: String = ""
    ): String = sharedPreferences.getString(key, defaultValue)!!
}
