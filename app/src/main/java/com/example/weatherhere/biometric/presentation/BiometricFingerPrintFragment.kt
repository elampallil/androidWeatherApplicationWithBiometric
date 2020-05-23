package com.example.weatherhere.biometric.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.weatherhere.R
import com.example.weatherhere.databinding.BiometricFingerPrintFragmentBinding

class BiometricFingerPrintFragment : BiometricPromt() {

    private lateinit var binding: BiometricFingerPrintFragmentBinding
    private lateinit var biometricFingerPrintViewModel: BiometricFingerPrintViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BiometricFingerPrintFragmentBinding.inflate(inflater, container, false)
        biometricFingerPrintViewModel =
            ViewModelProviders.of(this).get(BiometricFingerPrintViewModel::class.java)
        binding.biometricFingerPrintViewModel = biometricFingerPrintViewModel
        binding.lifecycleOwner = this
        setObservers()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    fun setObservers() {
        biometricFingerPrintViewModel.getButtonClickLiveData()
            .observe(viewLifecycleOwner, Observer {
                if (it.getContentIfNotHandld() == true) {
                    validatingBiometric()
                }

            })
    }

    override fun onAuthenticationSucceeded() {
        findNavController().navigate(R.id.action_biometricFingerPrintFragment_to_homeFragment)
    }


}
