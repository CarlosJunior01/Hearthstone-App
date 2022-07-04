package com.carlos.hearthstoneapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.carlos.hearthstoneapp.R
import com.carlos.hearthstoneapp.databinding.FragmentHearthstoneDetailsBinding

class HearthstoneDetailsFragment : Fragment() {

    private val arguments: HearthstoneDetailsFragmentArgs by navArgs()
    private lateinit var binding: FragmentHearthstoneDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentHearthstoneDetailsBinding.inflate(inflater, container, false)
        .apply { binding = this }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTextViews()
        setImageView(view)
        clickListeners()
    }

    private fun setTextViews() {
        binding.hearthstoneActionbar.txtHearthstoneTitle.text = arguments.name
        binding.txtCardName.text = resources.getString(R.string.card_name, arguments.name)
        binding.txtCardType.text = resources.getString(R.string.card_name, arguments.type)
        binding.txtCardFlavor.text = resources.getString(R.string.card_flavor, arguments.flavor)
        binding.txtCardText.text = resources.getString(R.string.card_text, arguments.description)
        binding.txtCardSet.text = resources.getString(R.string.card_set, arguments.set)
        binding.txtCardFaction.text = resources.getString(R.string.card_faction, arguments.faction)
        binding.txtCardRarity.text = resources.getString(R.string.card_rarity, arguments.rarity)
        binding.txtCardAttack.text = resources.getString(R.string.card_attack, arguments.attack)
        binding.txtCardCoast.text = resources.getString(R.string.card_cost, arguments.cost)
        binding.txtCardHealth.text = resources.getString(R.string.card_health, arguments.health)
    }

    private fun setImageView(view: View) {
        Glide.with(view)
            .load(arguments.image)
            .placeholder(R.drawable.hearthstone_logo)
            .into(binding.imgCard)
    }

    private fun clickListeners() {
        binding.hearthstoneActionbar.imgBackButton.setOnClickListener {
            findNavController().navigate(R.id.navigate_to_hearthstoneHomeFragment)
        }
    }
}