package com.github.kazaman97.shared_preferences_sample

import android.content.Context

class SharedPreferencesManager(private val context: Context) {
    companion object {
        private const val SP_NAME = "sample_preferences"
        private var _instance: SharedPreferencesManager? = null
        val instance: SharedPreferencesManager
            get() = _instance!!

        fun createInstance(context: Context): SharedPreferencesManager =
            synchronized(this) {
                _instance ?: SharedPreferencesManager(context).also {
                    _instance = it
                }
            }
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
