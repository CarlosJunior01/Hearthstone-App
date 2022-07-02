package com.carlos.hearthstoneapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.carlos.hearthstoneapp.databinding.FragmentHearthstoneBinding
import com.carlos.hearthstoneapp.presentation.adapter.HearthstoneHomeAdapter
import com.carlos.hearthstoneapp.presentation.model.setListHearthstoneClass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HearthstoneFragment : Fragment() {

    private lateinit var binding: FragmentHearthstoneBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentHearthstoneBinding.inflate(inflater, container, false)
        .apply { binding = this }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupIntroLoadingScreen()
        initHomeAdapter()
        clickListeners()

    }

    private fun setupIntroLoadingScreen() {
        CoroutineScope(Dispatchers.Main).launch {
            delay(THREE_SECONDS)
            switchFlipperChild(viewFlipperState = SHOW_CHILD_ONE)
        }
    }

    private fun switchFlipperChild(viewFlipperState: Int) {
        when (viewFlipperState) {
            SHOW_CHILD_ZERO -> binding.viewFlipperScreen.displayedChild = SHOW_CHILD_ZERO
            SHOW_CHILD_ONE -> binding.viewFlipperScreen.displayedChild = SHOW_CHILD_ONE
            SHOW_CHILD_TWO -> binding.viewFlipperScreen.displayedChild = SHOW_CHILD_TWO
            SHOW_CHILD_TWO -> binding.viewFlipperScreen.displayedChild = SHOW_CHILD_THREE
        }
    }

    private fun initHomeAdapter() {
        recyclerView = binding.homeScreen.recyclerHearthstone
        recyclerView.run {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
            adapter = HearthstoneHomeAdapter(setListHearthstoneClass()) { hearthstone ->
                switchFlipperChild(viewFlipperState = SHOW_CHILD_TWO)
                Toast.makeText(context, hearthstone.name, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun clickListeners() {
        binding.hearthstoneScreen.hearthstoneActionbar.imgBackButton.setOnClickListener {
            switchFlipperChild(viewFlipperState = SHOW_CHILD_ONE)
        }
    }

    companion object {
        private const val SHOW_CHILD_ZERO = 0
        private const val SHOW_CHILD_ONE = 1
        private const val SHOW_CHILD_TWO = 2
        private const val SHOW_CHILD_THREE = 3
        const val THREE_SECONDS = 3000L
    }

}
