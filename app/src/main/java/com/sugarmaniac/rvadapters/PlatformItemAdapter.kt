package com.sugarmaniac.rvadapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sugarmaniac.data.GeneralInterface
import com.sugarmaniac.data.Platform
import com.sugarmaniac.data.Sery
import com.sugarmaniac.noktatestcase.databinding.GeneralMovieItemLayoutBinding
import com.sugarmaniac.noktatestcase.databinding.PlatfromItemLayoutBinding

class PlatformItemAdapter(private var platformItems: List<Platform>, private val listener : (list: List<Sery>, position : Int) -> Unit) : RecyclerView.Adapter<PlatformItemAdapter.PlatformItemHolder>() {

    private var selectedItem = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlatformItemHolder {
        val binding = PlatfromItemLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return PlatformItemHolder(binding)
    }

    override fun getItemCount() = platformItems.size

    override fun onBindViewHolder(holder: PlatformItemHolder, position: Int) {
        with(holder){
            with(platformItems[position]){

                Glide.with(holder.itemView.context)
                    .load(this.appImage)
                    .into(binding.platformImage)

                holder.binding.root.setOnClickListener {
                    selectedItem = adapterPosition
                    listener.invoke(this.series, holder.adapterPosition)
                }
            }

            holder.binding.underLine.visibility = if (selectedItem == holder.adapterPosition){
                 View.VISIBLE
            } else {
                View.INVISIBLE
            }
        }
    }

    fun setList(list : List<Platform>){
        platformItems = list
        notifyDataSetChanged()
    }

    fun setCurrentSelected(position : Int) {
        notifyDataSetChanged()
    }


    inner class PlatformItemHolder(val binding: PlatfromItemLayoutBinding)
        : RecyclerView.ViewHolder(binding.root)

}