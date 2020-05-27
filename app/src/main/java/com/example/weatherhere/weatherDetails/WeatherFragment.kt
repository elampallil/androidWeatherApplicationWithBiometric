package com.example.weatherhere.weatherDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.weatherhere.databinding.WeatherFragmentBinding

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
        return binding.root
    }


}
