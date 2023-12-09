package com.example.squareequations.fragments

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreference
import com.example.squareequations.R

class SettingsFragment: PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
        findPreference<SwitchPreference>("showedTabs")?.setOnPreferenceChangeListener { _, newValue ->
            Log.d("tag", newValue.toString())
            val builder: AlertDialog.Builder? = context?.let { AlertDialog.Builder(it) }
            builder
                ?.setMessage("I am the message")
                ?.setTitle("I am the title")

            val dialog: AlertDialog? = builder?.create()
            dialog?.show()
            true
        }
    }

}