package com.carlos.hearthstoneapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.carlos.hearthstoneapp.R

class HearthstoneActivity : AppCompatActivity(R.layout.activity_hearthstone) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            val fragment: androidx.fragment.app.Fragment
            fragment = HearthstoneFragment()
            loadFragment(fragment)
        }
        hideActionBar()
    }

    private fun loadFragment(fragment: androidx.fragment.app.Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }

    private fun hideActionBar() {
        supportActionBar?.hide()
    }
}