package com.example.lab_mobdev.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.lab_mobdev.R
import com.example.lab_mobdev.model.Item
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment(var index: Int) : Fragment() {

    companion object {
        fun newInstance(index:Int) = SecondFragment(index)
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this.activity!!).get(MainViewModel::class.java)
        val item: Item = viewModel.items.get(index)
        title.text = item.title.toString()
        description.text = item.desc
        toolbar.setNavigationOnClickListener {
            this.activity!!.onBackPressed()
        }
    }


}