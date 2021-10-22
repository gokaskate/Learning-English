package com.skatincorp.le

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class BaseFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private fun onclick(item: Item) {
        findNavController().navigate(R.id.action_baseFragment_to_detailFragment, bundleOf("item" to item))
        Toast.makeText(context, item.name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_base, container, false)
        val listview = view.findViewById<RecyclerView>(R.id.list)
        listview.layoutManager = LinearLayoutManager(context)
        val list = when(arguments?.getInt("origin")){
            1 -> Lists.pronombres
            2 -> Lists.animales
            3 -> Lists.colores
            4 -> Lists.abecedario
            5 -> Lists.numeros
            else -> arrayOf()
        }
        listview.adapter = ListAdapter(list,::onclick)
        Log.d("bundle", arguments?.getInt("origin").toString())
        return view

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BaseFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}