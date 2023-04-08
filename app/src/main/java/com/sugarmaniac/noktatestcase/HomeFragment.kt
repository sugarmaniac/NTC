package com.sugarmaniac.noktatestcase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.sugarmaniac.noktatestcase.databinding.FragmentHomeBinding
import com.sugarmaniac.rvadapters.FeaturedItemRVAdapter
import com.sugarmaniac.rvadapters.GeneralItemAdapter
import com.sugarmaniac.rvadapters.MostTalkedItemAdapter
import com.sugarmaniac.rvadapters.PlatformItemAdapter

class HomeFragment : Fragment() {

    private val sharedViewModel : SharedViewModel by activityViewModels()
    private lateinit var binding : FragmentHomeBinding

    private lateinit var featuredItemRVAdapter: FeaturedItemRVAdapter
    private lateinit var onTheatherItemRVAdapter: GeneralItemAdapter
    private lateinit var platfromSeriesItemRVAdapter: GeneralItemAdapter
    private lateinit var upcomingItemRVAdapter: GeneralItemAdapter
    private lateinit var bornTodayItemRVAdapter: GeneralItemAdapter
    private lateinit var platfromAdapter : PlatformItemAdapter
    private lateinit var mostTalkedItemAdapter: MostTalkedItemAdapter


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

        onTheatherItemRVAdapter = GeneralItemAdapter(emptyList()){}
        binding.inTheatreRecyclerView.adapter = onTheatherItemRVAdapter

        platfromSeriesItemRVAdapter = GeneralItemAdapter(emptyList()){}
        binding.platformItemRv.adapter = platfromSeriesItemRVAdapter

        upcomingItemRVAdapter = GeneralItemAdapter(emptyList()){}
        binding.upcomingItemsRV.adapter = upcomingItemRVAdapter

        bornTodayItemRVAdapter = GeneralItemAdapter(emptyList()){}
        binding.bornTodayRV.adapter = bornTodayItemRVAdapter

        platfromAdapter = PlatformItemAdapter(emptyList()) { list, pos ->
            platfromAdapter.setCurrentSelected(pos)
            platfromSeriesItemRVAdapter.setList(list)
        }
        binding.platformRV.adapter = platfromAdapter

        mostTalkedItemAdapter = MostTalkedItemAdapter(emptyList()){}
        binding.mostTalkedRV.adapter = mostTalkedItemAdapter

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

        sharedViewModel.onTheatersItems.observe(viewLifecycleOwner){
            onTheatherItemRVAdapter.setList(it.flatten().take(10))
        }

        sharedViewModel.upComingItems.observe(viewLifecycleOwner){
            upcomingItemRVAdapter.setList(it)
        }

        sharedViewModel.topMovies.observe(viewLifecycleOwner){

        }

        sharedViewModel.trailers.observe(viewLifecycleOwner){

        }

        sharedViewModel.news.observe(viewLifecycleOwner){

        }

        sharedViewModel.bornTodays.observe(viewLifecycleOwner){
            bornTodayItemRVAdapter.setList(it)
        }

        sharedViewModel.recentLists.observe(viewLifecycleOwner){

        }

        sharedViewModel.popularArtist.observe(viewLifecycleOwner){
            mostTalkedItemAdapter.setList(it)
        }

        sharedViewModel.platforms.observe(viewLifecycleOwner){
            platfromAdapter.setList(it)
            platfromAdapter.setCurrentSelected(0)
            platfromSeriesItemRVAdapter.setList(it.getOrNull(0)?.series ?: emptyList())

        }
    }

    private fun setPlatformSeries(position : Int){
        platfromSeriesItemRVAdapter.setList(sharedViewModel.getPlatformItems(position))
    }


}