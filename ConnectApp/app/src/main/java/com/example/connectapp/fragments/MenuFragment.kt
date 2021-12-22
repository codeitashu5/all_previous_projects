package com.example.connectapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.connectapp.R
import com.example.connectapp.databinding.FragmentMenuBinding
import com.example.connectapp.viewModel.MainViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.sql.Types.NULL



class MenuFragment : Fragment() {
    private var _binding : FragmentMenuBinding? = null
    private val  binding get() = _binding!!
    val viewModel : MainViewModel by viewModels()
    private lateinit var recyclerView : RecyclerView

   private val BASE_URL = "https://jsonplaceholder.typicode.com/users"


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_menu,
            container,
            false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //you have to write your code here

        runBlocking {
              async { viewModel.getData() }.await()
        }

        setData()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setData() {

        if(recyclerView.layoutManager == null){
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }

       if(recyclerView.adapter == null){
           recyclerView.adapter = com.example.connectapp.recycler.adapter.ListAdapter(requireContext(),viewModel._response.value!!)
       }
        else{
            recyclerView.adapter!!.notifyDataSetChanged()
       }
    }


    override fun onDestroy() {
        _binding  = null
        super.onDestroy()
    }

}