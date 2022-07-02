package com.carlos.hearthstoneapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.carlos.hearthstoneapp.databinding.FragmentHearthstoneBinding

class HearthstoneFragment : Fragment() {

    private lateinit var binding: FragmentHearthstoneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentHearthstoneBinding.inflate(inflater, container, false)
        .apply { binding = this }.root

}