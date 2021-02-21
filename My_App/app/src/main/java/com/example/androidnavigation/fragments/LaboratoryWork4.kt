package com.example.androidnavigation.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.androidnavigation.R
import kotlinx.android.synthetic.main.fragment_laboratory_work4.*

class LaboratoryWork4 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_laboratory_work4, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.my_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.get_back) {
            "Приветствуем Вас в списке станций Днепровского метрополитена"
        } else {
            "Вы находитесь на станции \"${item?.title}\""
        }.let {
            main_text.text = it
        }
        return super.onOptionsItemSelected(item)
    }
}