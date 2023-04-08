package com.sugarmaniac.rvadapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sugarmaniac.data.GeneralInterface
import com.sugarmaniac.data.Platform
import com.sugarmaniac.data.PopularArtist
import com.sugarmaniac.data.Sery
import com.sugarmaniac.noktatestcase.databinding.GeneralMovieItemLayoutBinding
import com.sugarmaniac.noktatestcase.databinding.MostTalkedItemLayoutBinding
import com.sugarmaniac.noktatestcase.databinding.PlatfromItemLayoutBinding

class MostTalkedItemAdapter(private var mostTalkedItems: List<PopularArtist>, private val listener : () -> Unit) : RecyclerView.Adapter<MostTalkedItemAdapter.MostTalkedItemHolder>() {

    private var selectedItem = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostTalkedItemHolder {
        val binding = MostTalkedItemLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MostTalkedItemHolder(binding)
    }

    override fun getItemCount() = mostTalkedItems.size

    override fun onBindViewHolder(holder: MostTalkedItemHolder, position: Int) {
        with(holder){
            with(mostTalkedItems[position]){

                Glide.with(holder.itemView.context)
                    .load(this.picture)
                    .into(binding.image)

                binding.name.text = this.name_surname
            }

        }
    }

    fun setList(list : List<PopularArtist>){
        mostTalkedItems = list
        notifyDataSetChanged()
    }

    fun setCurrentSelected(position : Int) {
        notifyDataSetChanged()
    }


    inner class MostTalkedItemHolder(val binding: MostTalkedItemLayoutBinding)
        : RecyclerView.ViewHolder(binding.root)

}