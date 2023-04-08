package com.sugarmaniac.noktatestcase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.PagerSnapHelper
import com.sugarmaniac.noktatestcase.databinding.FragmentHomeBinding
import com.sugarmaniac.rvadapters.FeaturedItemRVAdapter

class HomeFragment : Fragment() {

    private val sharedViewModel : SharedViewModel by activityViewModels()
    private lateinit var binding : FragmentHomeBinding

    private lateinit var featuredItemRVAdapter: FeaturedItemRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        initViews()
        initObservers()
        return binding.root
    }

    private fun initViews() {

        featuredItemRVAdapter = FeaturedItemRVAdapter(emptyList()){}
        binding.featuredItems.adapter = featuredItemRVAdapter


        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.featuredItems)

        val indicator = binding.indicator
        indicator.attachToRecyclerView(binding.featuredItems, snapHelper)
        featuredItemRVAdapter.registerAdapterDataObserver(indicator.adapterDataObserver)


    }

    private fun initObservers() {
        sharedViewModel.featuredItems.observe(viewLifecycleOwner){
            featuredItemRVAdapter.setList(it)
        }

    }


}