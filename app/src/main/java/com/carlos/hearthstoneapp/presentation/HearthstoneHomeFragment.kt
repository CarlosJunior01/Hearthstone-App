package com.carlos.hearthstoneapp.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.carlos.hearthstoneapp.databinding.FragmentHearthstoneBinding
import com.carlos.hearthstoneapp.presentation.adapter.HearthstoneAdapter
import com.carlos.hearthstoneapp.presentation.adapter.HearthstoneHomeAdapter
import com.carlos.hearthstoneapp.presentation.model.CardViewObject
import com.carlos.hearthstoneapp.presentation.model.StateResponse
import com.carlos.hearthstoneapp.presentation.model.setListHearthstoneClass
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HearthstoneHomeFragment : Fragment() {

    private val viewModel by viewModels<HearthstoneViewModel>()

    private lateinit var binding: FragmentHearthstoneBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentHearthstoneBinding.inflate(inflater, container, false)
        .apply { binding = this }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initHomeAdapter()
        clickListeners()
        collectState()
    }

    private fun initHomeAdapter() {
        recyclerView = binding.homeScreen.recyclerHomeHearthstone
        recyclerView.run {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, TWO_VALUE)
            adapter = HearthstoneHomeAdapter(setListHearthstoneClass()) { hearthstone ->
                switchFlipperChild(viewFlipperState = SHOW_CHILD_ONE)
                viewModel.getAllCards(hearthstone.name)
                Toast.makeText(context, hearthstone.name, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun clickListeners() {
        binding.hearthstoneScreen.hearthstoneActionbar.imgBackButton.setOnClickListener {
            switchFlipperChild(viewFlipperState = SHOW_CHILD_ZERO)
        }

        binding.hearthstoneScreen.hearthstoneActionbar.imgBackButton.setOnClickListener {
            switchFlipperChild(viewFlipperState = SHOW_CHILD_ZERO)
        }

        binding.errorScreen.btnTryAgain.setOnClickListener {
            switchFlipperChild(viewFlipperState = SHOW_CHILD_ZERO)
        }
    }

    private fun collectState() {
        lifecycleScope.launchWhenCreated {
            viewModel.screenState.collect { state ->
                when (state) {
                    is StateResponse.StateLoading -> {
                        binding.hearthstoneScreen.shimmerLayout.visibility = View.VISIBLE
                        binding.hearthstoneScreen.recyclerHearthstone.visibility = View.GONE
                    }
                    is StateResponse.StateSuccess -> {
                        binding.hearthstoneScreen.shimmerLayout.visibility = View.GONE
                        binding.hearthstoneScreen.recyclerHearthstone.visibility = View.VISIBLE
                        initHearthstoneAdapter(state.cardVO)
                    }
                    is StateResponse.StateError -> setErrorState()
                }
            }
        }
    }

    private fun switchFlipperChild(viewFlipperState: Int) {
        when (viewFlipperState) {
            SHOW_CHILD_ZERO -> binding.viewFlipperScreen.displayedChild = SHOW_CHILD_ZERO
            SHOW_CHILD_ONE -> binding.viewFlipperScreen.displayedChild = SHOW_CHILD_ONE
            SHOW_CHILD_TWO -> binding.viewFlipperScreen.displayedChild = SHOW_CHILD_TWO
        }
    }

    private fun initHearthstoneAdapter(cardVO: List<CardViewObject>) {
        recyclerView = binding.hearthstoneScreen.recyclerHearthstone
        recyclerView.run {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, ONE_VALUE)
            adapter = HearthstoneAdapter(cardVO) { hearthstone ->
                Toast.makeText(context, hearthstone.name, Toast.LENGTH_SHORT).show()
                findNavController().navigate(setActionNavigate(hearthstone))
            }
        }
    }

    private fun setActionNavigate(hearthstone: CardViewObject) =
        HearthstoneHomeFragmentDirections.navigateToHearthstoneDetailsFragment(hearthstone)

    private fun setErrorState() = switchFlipperChild(viewFlipperState = SHOW_CHILD_TWO)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() { activity?.finish() }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    companion object {
        private const val SHOW_CHILD_ZERO = 0
        private const val SHOW_CHILD_ONE = 1
        private const val SHOW_CHILD_TWO = 2
        private const val ONE_VALUE = 1
        private const val TWO_VALUE = 2
    }
}
