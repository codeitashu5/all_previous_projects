package com.ashupandey.footballtutorails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ashupandey.footballtutorails.recycler.resource.CustomAdapter
import com.ashupandey.footballtutorails.recycler.resource.DataList
import com.ashupandey.footballtutorails.recycler.resource.ItemClicked
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),ItemClicked {
    private val list = DataList().listRecycler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        recyclerView.adapter = CustomAdapter(list,this)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun itemClickedListner(position: Int) {
        val i = Intent(this,ActivityRecycler::class.java)
        i.putExtra( KEY_TITTLE , list[position].skill)
        startActivity(i)
    }


    companion object{
        const val KEY_TITTLE = "what"
    }
}
