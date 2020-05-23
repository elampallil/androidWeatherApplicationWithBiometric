package com.example.weatherhere.biometric.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.weatherhere.R
import java.util.concurrent.Executor

abstract class BiometricPromt : Fragment() {
    private var isBiometricSupport = false

    private lateinit var executor: Executor
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var promptInfo: BiometricPrompt.PromptInfo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_biometric_promt, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        executor = ContextCompat.getMainExecutor(context)


    }

    private fun canSupportBiometricInYourHardWare(): Boolean {
        context?.let {
            val biometricManager = BiometricManager.from(it)
            when (biometricManager.canAuthenticate()) {
                BiometricManager.BIOMETRIC_SUCCESS -> isBiometricSupport = true

                BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> isBiometricSupport = false

                BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> isBiometricSupport = false

                BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> isBiometricSupport = false

            }
        }
        return isBiometricSupport


    }

    private fun biometricAuthentication(): BiometricPrompt {
        biometricPrompt = BiometricPrompt(this, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(
                    errorCode: Int,
                    errString: CharSequence
                ) {
                    super.onAuthenticationError(errorCode, errString)
                    Toast.makeText(
                        context,
                        "Authentication error: $errString", Toast.LENGTH_SHORT
                    )
                        .show()
                }

                override fun onAuthenticationSucceeded(
                    result: BiometricPrompt.AuthenticationResult
                ) {
                    super.onAuthenticationSucceeded(result)
                    Toast.makeText(
                        context,
                        "Authentication succeeded!", Toast.LENGTH_SHORT
                    )
                        .show()
                    onAuthenticationSucceeded()
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Toast.makeText(
                        context, "Authentication failed",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            })
        return biometricPrompt

    }

    fun setPromtInfo(): BiometricPrompt.PromptInfo {
        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Biometric login for my app")
            .setSubtitle("Log in using your biometric credential")
            .setNegativeButtonText("Use account password")
            .build()
        return promptInfo

    }
     fun validatingBiometric(){
        val promtInfo =setPromtInfo()
        val biometricPromt = biometricAuthentication()
        biometricPromt.authenticate(promtInfo)

    }
    abstract fun onAuthenticationSucceeded()

}
