package com.ashupandey.footballtutorails.fragments


import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ashupandey.footballtutorails.R
import kotlinx.android.synthetic.main.fragment_skill.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentSkill.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentSkill : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //doing all my work here only
        val image = arguments?.getInt("imageId")
        imageViewFarament.setImageResource(image!!)
        textViewFrame.text = arguments?.getString("tittle")
        



        buttonPass.setOnClickListener {
            //for implict intent we quive action and query url
            val queryUri = Uri.parse("https://www.youtube.com/watch?v=QioehtsQMxs&ab_channel=7mlc")
            val i = Intent(ACTION_VIEW,queryUri)
            startActivity(i)
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentSkill.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentSkill().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

//Having different level for each and every skill to crate an guided path for each and every skill

/*
Concepts used
1.Recycler view
2.Activity
3.Fragments
4.Custom Menu bar
5.Explicit intent
6.Implicit intent
 */

/*
 Walk Through The Project

 The front activity is used to used to show the recycler view in the app which have an on click listener which will call an implicit intent that will lead us to the next activity
 named ActivityRecycler where we have implemented fragment part

 */


/*
 In the RecyclerActivity that i have called using the explicit intent that had provided us with the value of string that we have in the particular item of recycler view that is used to
 to show in fragment and crate three different fragment transaction on the basis of the menu button clicked
 */

/*
use of menu to do fragment transaction and add different fragments according to the menu button clicked and replace the previous one with the current one the bundles are used to
pass the values in in the fragment from the activity which are used to show the desired result as intended
 */

/*
 Use of url to to get to the specific location using the implicit intent and collection of data set of url to get to the correct resource is very important for the project to
 perform at its optimal and give us the desired satisfaction of the user and that is to be implemented using the concept of matrix which will have N->rows which is for the
 each and every recycler view and 3->column for each and every difficulty level
 */

/*
Use of explicit intent to get from your app to the youtube page for the required video for the specific fragment as required that happens on the click of button inside the fragment

 */