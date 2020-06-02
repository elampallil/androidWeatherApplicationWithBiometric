package com.example.weatherhere.googleMap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherhere.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapsFragment : Fragment() {


    private val callback = OnMapReadyCallback { googleMap ->

        val sydney = LatLng(10.8505, 76.2711)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Iam Here"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
/*
      val locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE)
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this)*/
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

}