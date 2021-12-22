package com.example.databaseimplimentation.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.databaseimplimentation.R
import com.example.databaseimplimentation.daos.AppDataBase
import com.example.databaseimplimentation.data.Item
import com.example.databaseimplimentation.databinding.FragmentPersonListBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

private var _binding : FragmentPersonListBinding? = null
private val binding get() = _binding!!
const val TAG = "listCheck"

class PersonListFragment : Fragment() {

    lateinit var list : LiveData<MutableList<Item>>
    lateinit var list1 : LiveData<MutableList<Item>>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPersonListBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val getDatabase = Room.databaseBuilder(requireContext(),
            AppDataBase::class.java,
            "db_user")
            .fallbackToDestructiveMigration()
            .build()

        val daoUser =  getDatabase.getDaoItem()

        for(i in 25..49){
            val item  = Item(0,"Ashutosh",i,"M")
            runBlocking {
                withContext(Dispatchers.IO){
                    daoUser.insert(item)
                }
            }
        }

        runBlocking { 
            withContext(Dispatchers.IO){
                list =  daoUser.getResult()
            }
            
        }
        
        runBlocking { 
            withContext(Dispatchers.IO){
                list1 = daoUser.getValue()
            }
        }
        
        list.value?.let { 
            for(i in it){
                Log.d(TAG, "\n onViewCreated: ${i.age}")
            }
        }

        binding.btnDel.setOnClickListener {
            runBlocking {

                if(list1.value!!.size!=0){
                    withContext(Dispatchers.IO){
                        daoUser.delete(list1.value!!)
                    }
                }
                else{
                    Toast.makeText(requireContext(), "list is empty", Toast.LENGTH_SHORT).show()
                }
            }
        }

        list.observe(viewLifecycleOwner,{
            Log.d(TAG, "onViewCreated: ${it.size}")
        })

        list1.observe(viewLifecycleOwner,{
            Log.d(TAG, "onViewCreated: ${it.size}") })

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}