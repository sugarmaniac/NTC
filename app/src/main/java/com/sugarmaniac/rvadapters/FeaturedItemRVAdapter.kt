package com.sugarmaniac.rvadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sugarmaniac.data.Featured
import com.sugarmaniac.noktatestcase.databinding.FeaturedItemLayoutBinding

class FeaturedItemRVAdapter(private var featuredItems: List<Featured>, private val listener : (input: String) -> Unit) : RecyclerView.Adapter<FeaturedItemRVAdapter.FeaturedItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturedItemHolder {
        val binding = FeaturedItemLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return FeaturedItemHolder(binding)
    }

    override fun getItemCount() = featuredItems.size

    override fun onBindViewHolder(holder: FeaturedItemHolder, position: Int) {
        with(holder){
            with(featuredItems[position]) {
                binding.nameEn.text = this.org_name
                binding.nameTR.text = this.name
                binding.button.text = when (this.ontheaters) {
                    "now" -> { "Seansları Gör" }
                    else -> { "Fragmanı İzle" }
                }

                Glide.with(holder.itemView.context)
                    .load(this.image)
                    .into(binding.image)
            }
        }
    }

    fun setList(list : List<Featured>){
        featuredItems = list
        notifyDataSetChanged()
    }


    inner class FeaturedItemHolder(val binding: FeaturedItemLayoutBinding)
        : RecyclerView.ViewHolder(binding.root)

}