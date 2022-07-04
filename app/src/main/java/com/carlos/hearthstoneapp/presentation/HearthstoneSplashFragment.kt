package com.carlos.hearthstoneapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.carlos.hearthstoneapp.R
import com.carlos.hearthstoneapp.databinding.FragmentHearthstoneSplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HearthstoneSplashFragment : Fragment() {

    private lateinit var binding: FragmentHearthstoneSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentHearthstoneSplashBinding.inflate(inflater, container, false)
        .apply { binding = this }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupIntroLoadingScreen()
    }

    private fun setupIntroLoadingScreen() {
        CoroutineScope(Dispatchers.Main).launch {
            delay(THREE_SECONDS)
            findNavController().navigate(R.id.navigate_to_hearthstoneHomeFragment)
        }
    }

    companion object {
        private const val THREE_SECONDS = 3000L
    }
}
