package com.example.androidnavigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.example.androidnavigation.R
import kotlinx.android.synthetic.main.fragment_laboratory_work3.*

class LaboratoryWork3 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_laboratory_work3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sunRiseAnimation = AnimationUtils.loadAnimation(context, R.anim.sun_rise)
        sun.startAnimation(sunRiseAnimation);
    }
}