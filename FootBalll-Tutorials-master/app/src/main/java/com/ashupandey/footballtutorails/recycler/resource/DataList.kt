package com.ashupandey.footballtutorails.recycler.resource

import android.content.Context
import android.widget.ImageView
import com.ashupandey.footballtutorails.R

class DataList {
    fun listRecycler():MutableList<Data>{
        val mutableList = mutableListOf<Data>()
        //provide data to list

        mutableList.add(Data("Passing",R.drawable.ic_passing))
        mutableList.add(Data("Receving",R.drawable.ic_receving))
        mutableList.add(Data("Shooting",R.drawable.ic_shooting))
        mutableList.add(Data("Stamina",R.drawable.ic_stamina))
        mutableList.add(Data("Dribbling",R.drawable.ic_dribbling))
        mutableList.add(Data("Juggling",R.drawable.ic_juggling))
        mutableList.add(Data("Diet",R.drawable.ic_diet))
        mutableList.add(Data("Streaches",R.drawable.ic_straches))
        mutableList.add(Data("Clubs",R.drawable.ic_clubs))



        return mutableList
    }
}