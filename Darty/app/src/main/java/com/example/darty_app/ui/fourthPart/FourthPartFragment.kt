package com.example.darty_app.ui.fourthPart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.darty_app.R
import com.example.darty_app.ui.secondPart.SecondPartViewModel


class FourthPartFragment : Fragment() {

    private lateinit var fourthPartViewModel: FourthPartViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        fourthPartViewModel =
                ViewModelProvider(this).get(FourthPartViewModel::class.java)
        val root = inflater.inflate(R.layout.fourth_part_fragment, container, false)
        val textView: TextView = root.findViewById(R.id.fourth_part_fragment)
        fourthPartViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}