package com.sugarmaniac.rvadapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sugarmaniac.data.NewListInterface
import com.sugarmaniac.data.TrailerX
import com.sugarmaniac.noktatestcase.databinding.NewsListItemLayoutBinding
import com.sugarmaniac.noktatestcase.databinding.TrailerItemLayoutBinding

class NewsListItemAdapter(private var newList: List<NewListInterface>, private val listener : (input: String) -> Unit) : RecyclerView.Adapter<NewsListItemAdapter.NewsListItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListItemHolder {
        val binding = NewsListItemLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsListItemHolder(binding)
    }

    override fun getItemCount() = newList.size

    override fun onBindViewHolder(holder: NewsListItemHolder, position: Int) {
        with(holder){
            with(newList[position]){

                Glide.with(holder.itemView.context)
                    .load(this.takeImage())
                    .into(binding.image)

                if (this.hasTrailer()){
                    binding.play.visibility = View.VISIBLE
                }

                binding.title.text = this.takeName()
                binding.time.text = this.takeTimeAdded()
            }



        }
    }

    fun setList(list : List<NewListInterface>){
        newList = list
        notifyDataSetChanged()
    }


    inner class NewsListItemHolder(val binding: NewsListItemLayoutBinding)
        : RecyclerView.ViewHolder(binding.root)

}