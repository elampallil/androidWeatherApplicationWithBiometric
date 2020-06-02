package com.example.weatherhere.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.weatherhere.R
import com.example.weatherhere.databinding.HomeFragmentBinding
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding
    private lateinit var homeViewModel: HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding.homeViewModel = homeViewModel
        binding.lifecycleOwner = this
        setObservers()
        return binding.root
    }

    fun setObservers() {
        homeViewModel.getSumbmitButtonClickLiveData().observe(viewLifecycleOwner, Observer {
            if (it.getContentIfNotHandld() == true) {
                val place = et_enter_the_text.text.toString()
                progress_bar.visibility = View.VISIBLE
                homeViewModel.getWeatherDetails(place)
            }
        })
        homeViewModel.getWeatherResponseLiveData().observe(viewLifecycleOwner, Observer {
            val consolidatedWeatherList = it.consolidated_weather
            val consolidatedWeather = consolidatedWeatherList.get(0)
            val bundle = bundleOf("weather" to consolidatedWeather)
            progress_bar.visibility = View.GONE
            findNavController().navigate(R.id.action_homeFragment_to_weatherFragment, bundle)
        })
        homeViewModel.getFindMyLocationLiveData().observe(viewLifecycleOwner, Observer {
            if(it.getContentIfNotHandld()==true){
                findNavController().navigate(R.id.action_homeFragment_to_mapsFragment)
            }
        })

    }
}
