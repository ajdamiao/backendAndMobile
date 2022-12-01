package com.ajdamiao.parkspot.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ajdamiao.parkspot.R
import com.ajdamiao.parkspot.adapter.ParkSpotAdapter
import com.ajdamiao.parkspot.databinding.FragmentHomeBinding
import com.ajdamiao.parkspot.model.ParkSpot
import com.ajdamiao.parkspot.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private val parkSpotAdapter = ParkSpotAdapter()
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)
        homeViewModel.getParkSpots()

        homeViewModel.parkSpots.observe(viewLifecycleOwner) {
            when {
                it.parkSpots.size != 0 -> { setupParkSpotList(it.parkSpots) }
            }
        }
    }

    private fun setupParkSpotList(parkSpot: ArrayList<ParkSpot>) {
        parkSpotAdapter.addParkSpot(parkSpot)

        binding.run {
            rviewParkSpot.layoutManager = LinearLayoutManager(requireContext())
            rviewParkSpot.adapter = parkSpotAdapter
        }
    }
}