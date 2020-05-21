package com.example.weatherhere.biometric.presentation

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.weatherhere.R

class BiometricFingerPrintFragment : Fragment() {

    companion object {
        fun newInstance() = BiometricFingerPrintFragment()
    }

    private lateinit var viewModel: BiometricFingerPrintViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.biometric_finger_print_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BiometricFingerPrintViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
