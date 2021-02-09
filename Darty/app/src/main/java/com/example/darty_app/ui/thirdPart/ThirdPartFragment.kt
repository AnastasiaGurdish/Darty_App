package com.example.darty_app.ui.thirdPart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.darty_app.R

class ThirdPartFragment : Fragment() {

  private lateinit var thirdPartViewModel: ThirdPartViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    thirdPartViewModel =
            ViewModelProvider(this).get(ThirdPartViewModel::class.java)
    val root = inflater.inflate(R.layout.third_part_fragment, container, false)
    val textView: TextView = root.findViewById(R.id.third_part_fragment)
    thirdPartViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
    })
    return root
  }
}