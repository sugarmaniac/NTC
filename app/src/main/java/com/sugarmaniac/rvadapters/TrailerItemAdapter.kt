package com.sugarmaniac.rvadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sugarmaniac.data.TrailerX
import com.sugarmaniac.noktatestcase.databinding.TrailerItemLayoutBinding

class TrailerItemAdapter(private var trailerItems: List<TrailerX>, private val listener : (input: String) -> Unit) : RecyclerView.Adapter<TrailerItemAdapter.TrailerItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrailerItemHolder {
        val binding = TrailerItemLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return TrailerItemHolder(binding)
    }

    override fun getItemCount() = trailerItems.size

    override fun onBindViewHolder(holder: TrailerItemHolder, position: Int) {
        with(holder){
            with(trailerItems[position]){

                Glide.with(holder.itemView.context)
                    .load(this.thumbnail)
                    .into(binding.fragmentThumbnail)
            }
        }
    }

    fun setList(list : List<TrailerX>){
        trailerItems = list
        notifyDataSetChanged()
    }


    inner class TrailerItemHolder(val binding: TrailerItemLayoutBinding)
        : RecyclerView.ViewHolder(binding.root)

}