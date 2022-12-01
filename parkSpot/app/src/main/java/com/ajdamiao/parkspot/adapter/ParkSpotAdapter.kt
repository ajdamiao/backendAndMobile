package com.ajdamiao.parkspot.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ajdamiao.parkspot.databinding.RviewParkSpotBinding
import com.ajdamiao.parkspot.model.ParkSpot

class ParkSpotAdapter: RecyclerView.Adapter<ParkSpotAdapter.ParkSpotViewHolder>() {
    inner class ParkSpotViewHolder(val binding: RviewParkSpotBinding) : RecyclerView.ViewHolder(binding.root)
    private val parkSpotList = ArrayList<ParkSpot>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ParkSpotAdapter.ParkSpotViewHolder {
        val binding = RviewParkSpotBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ParkSpotViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ParkSpotAdapter.ParkSpotViewHolder, position: Int) {
        with(holder) {
            with(parkSpotList[position]) {

                binding.run {
                    txtCarName.text = modelCar
                    txtCarPlate.text = licensePlateCar
                    txtParkingSpotNumber.text = parkingSpotNumber
                    txtResponsibleName.text = responsibleName
                }

                itemView.setOnClickListener {
                    val bundle = Bundle()
                    bundle.putString("id", id)
                }
            }
        }
    }

    override fun getItemCount() = parkSpotList.size

    fun addParkSpot(newParkSpot: ArrayList<ParkSpot>) {
        newParkSpot.forEach { t ->
            if(!parkSpotList.contains(t)) {
                parkSpotList.add(t)
            }
        }
    }
}