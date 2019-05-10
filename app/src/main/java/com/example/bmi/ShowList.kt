package com.example.bmi


import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.example.bmi.AdaptorListView.ListWeightAdaptor
import com.example.bmi.DBHelper.DBHelper
import com.example.bmi.Model.Weightdb
import kotlinx.android.synthetic.main.list_view.*

class ShowList : AppCompatActivity() {


    lateinit var lstview:ListView
    internal var db=DBHelper(this)
    var list = mutableListOf<Weightdb>()
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view)
        lstview =list_view
        viewAll()
        val adapter=ListWeightAdaptor(this,R.layout.row,list)
        lstview.adapter=adapter
    }

    private fun viewAll() {
        list.clear()
        val res= db.allWeight
        if(res.count==0){
            Toast.makeText(this,"no record",Toast.LENGTH_LONG).show()
        }
        while(res.moveToNext()){
            list.add(Weightdb(res.getString(0),
                res.getString(1)))
        }

    }


}

