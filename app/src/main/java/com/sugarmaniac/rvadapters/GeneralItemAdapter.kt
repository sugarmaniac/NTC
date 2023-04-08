package com.sugarmaniac.rvadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sugarmaniac.data.GeneralInterface
import com.sugarmaniac.noktatestcase.databinding.GeneralMovieItemLayoutBinding

class GeneralItemAdapter(private var generalItems: List<GeneralInterface>, private val listener : (input: String) -> Unit) : RecyclerView.Adapter<GeneralItemAdapter.GenericItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericItemHolder {
        val binding = GeneralMovieItemLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return GenericItemHolder(binding)
    }

    override fun getItemCount() = generalItems.size

    override fun onBindViewHolder(holder: GenericItemHolder, position: Int) {
        with(holder){
            with(generalItems[position]){
                binding.title.text = this.takeName()


                    Glide.with(holder.itemView.context)
                        .load(this.takeUrl())
                        .into(binding.image)
            }
        }
    }

    fun setList(list : List<GeneralInterface>){
        generalItems = list
        notifyDataSetChanged()
    }


    inner class GenericItemHolder(val binding: GeneralMovieItemLayoutBinding)
        : RecyclerView.ViewHolder(binding.root)

}