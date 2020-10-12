package com.example.lab_mobdev.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_mobdev.ContainsItem
import com.example.lab_mobdev.R
import com.example.lab_mobdev.adapter.ItemAdapter
import com.example.lab_mobdev.model.Item
import kotlinx.android.synthetic.main.main_fragment.*

class Lab4Fragment : Fragment(), ContainsItem {

    override fun itemClick(index:Int) {
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.replace(R.id.container,SecondFragment.newInstance(index))
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    companion object {
        fun newInstance() = Lab4Fragment()
    }

    private lateinit var viewModel: MainViewModel

    fun addMemo(title:String, desc:String){
        viewModel.items.add(Item(title,desc))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this.activity!!).get(MainViewModel::class.java)

        content.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        content.adapter = ItemAdapter(viewModel.items, activity!!.applicationContext,this)
        fab.setOnClickListener {
            card.visibility = View.VISIBLE
            fab.hide();
        }

        content.setOnClickListener {
            card.visibility = View.GONE
            fab.show()
        }

        add.setOnClickListener {
            if (!search.text.isEmpty() && !desc.text.isEmpty()){
                addMemo(search.text.toString(),desc.text.toString())
                search.text.clear()
                desc.text.clear()
                card.visibility = View.GONE
                fab.show()
            }

        }

    }

}