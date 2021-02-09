package com.example.darty_app.ui.firstPart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.darty_app.R

class FirstPartFragment : Fragment() {

  private lateinit var firstPartViewModel: FirstPartViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    firstPartViewModel =
            ViewModelProvider(this).get(FirstPartViewModel::class.java)
    val root = inflater.inflate(R.layout.first_part_fragment, container, false)
    val textView: TextView = root.findViewById(R.id.first_part_fragment)
    firstPartViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
    })
    return root
  }
}