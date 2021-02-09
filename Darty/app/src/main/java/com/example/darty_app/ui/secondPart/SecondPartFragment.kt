package com.example.darty_app.ui.secondPart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.darty_app.R

class SecondPartFragment : Fragment() {

  private lateinit var secondPartViewModel: SecondPartViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    secondPartViewModel =
            ViewModelProvider(this).get(SecondPartViewModel::class.java)
    val root = inflater.inflate(R.layout.second_part_fragment, container, false)
    val textView: TextView = root.findViewById(R.id.second_part_fragment)
    secondPartViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
    })
    return root
  }
}