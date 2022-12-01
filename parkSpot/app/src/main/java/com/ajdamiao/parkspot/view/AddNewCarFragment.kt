package com.ajdamiao.parkspot.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ajdamiao.parkspot.R
import com.ajdamiao.parkspot.databinding.FragmentAddNewCarBinding

class AddNewCarFragment : Fragment(R.layout.fragment_add_new_car) {
    private lateinit var binding: FragmentAddNewCarBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentAddNewCarBinding.bind(view)



    }
}