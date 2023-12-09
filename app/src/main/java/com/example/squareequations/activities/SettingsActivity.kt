package com.example.squareequations.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.squareequations.R
import com.example.squareequations.databinding.ActivitySettingsBinding
import com.example.squareequations.fragments.SettingsFragment

class SettingsActivity: AppCompatActivity(){
    private lateinit var binding: ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, SettingsFragment())
            .commit()
    }
}