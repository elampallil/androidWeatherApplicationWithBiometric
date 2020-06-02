package com.example.weatherhere.weatherDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.weatherhere.R
import com.example.weatherhere.databinding.WeatherFragmentBinding
import com.example.weatherhere.home.domain.ConsolidatedWeather

class WeatherFragment : Fragment() {

    private lateinit var binding: WeatherFragmentBinding
    private lateinit var weatherViewModel: WeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = WeatherFragmentBinding.inflate(inflater, container, false)
        weatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)
        binding.weatherViewModel = weatherViewModel
        binding.lifecycleOwner = this
        setObservers()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { bundle ->
            val consolidateWeather = bundle.getParcelable < ConsolidatedWeather>("weather")
            consolidateWeather?.let {
                weatherViewModel.setWeatherDetailsToLiveData(it)
            }
        }
    }
    fun setObservers(){
        weatherViewModel.getBackIconClickLiveData().observe(viewLifecycleOwner, Observer {
            if(it.getContentIfNotHandld()==true){
                findNavController().navigate(R.id.action_weatherFragment_to_homeFragment)
            }
        })
    }


}
