package com.example.bugsmirrortask.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.bugsmirrortask.R
import com.example.bugsmirrortask.databinding.FragmentPermissionsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentPermissions.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentPermissions : Fragment() {
    private var _binding: FragmentPermissionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPermissionsBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //we will do our work here
        binding.buttonPerm.setOnClickListener {
            //get the text from edit-text
            val text = binding.editText.text.toString()
            list.add(text)
            binding.editText.setText("")
            val action = FragmentPermissionsDirections.actionFragmentPermissionsToFragmentList(text)
            findNavController().navigate(action)
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object{
       val list = mutableListOf<String>()
    }
}

