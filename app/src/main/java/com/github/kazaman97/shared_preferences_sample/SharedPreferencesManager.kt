package com.github.kazaman97.shared_preferences_sample

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPreferencesManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    companion object {
        private const val SP_NAME = "sample_preferences"
        private const val ENCRYPT_SP_NAME = "sample_encrypt_preferences"
    }

    private val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
    private val mainKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)

    private val sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
    private val encryptedSharedPreferences = EncryptedSharedPreferences.create(
        ENCRYPT_SP_NAME,
        mainKeyAlias,
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun putString(
        key: String,
        value: String,
        isEncrypted: Boolean = false
    ) {
        removeString(key)
        if (isEncrypted) {
            encryptedSharedPreferences.edit()
                .putString(key, value)
                .apply()
            return
        }
        sharedPreferences.edit()
            .putString(key, value)
            .apply()
    }

    fun removeString(key: String) {
        sharedPreferences.edit()
            .remove(key)
            .apply()
        encryptedSharedPreferences.edit()
            .remove(key)
            .apply()
    }

    fun getString(
        key: String,
        defaultValue: String = "",
    ): String {
        return sharedPreferences.getString(key, null)
            ?: encryptedSharedPreferences.getString(key, null)
            ?: defaultValue
    }
}
