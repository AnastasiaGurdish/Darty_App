package com.example.androidnavigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.androidnavigation.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_laboratory_work2.*

class LaboratoryWork2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_laboratory_work2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_apply.setOnClickListener {
            if (checkbox_id.isChecked) {
                image_view.visibility =
                    if (image_view.isVisible) View.GONE else View.VISIBLE
            } else {
                Snackbar.make(view, "Сначала отметьте чекбокс!", 1000).show()
            }

        }
    }
}