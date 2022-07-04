package com.carlos.hearthstoneapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.carlos.hearthstoneapp.databinding.ActivityHearthstoneBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HearthstoneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHearthstoneBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}