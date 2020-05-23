package com.example.weatherhere.splash.presentation

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.weatherhere.R
import com.example.weatherhere.databinding.SplashFragmentBinding

class SplashFragment : Fragment() {

    private lateinit var binding: SplashFragmentBinding
    private lateinit var splashViewModel: SplashViewModel
    private val SPLASH_TIME_OUT = 3000L


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SplashFragmentBinding.inflate(inflater, container, false)
        splashViewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        binding.splashViewModel = splashViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed({
          moveToNext()
        },SPLASH_TIME_OUT)


    }
    private  fun moveToNext(){
        findNavController().navigate(R.id.action_splashFragment_to_biometricFingerPrintFragment)
    }


}
