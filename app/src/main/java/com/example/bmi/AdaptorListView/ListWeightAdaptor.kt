package com.example.bmi.AdaptorListView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.bmi.DBHelper.DBHelper
import com.example.bmi.Model.Weightdb
import com.example.bmi.R

class ListWeightAdaptor(var mCtx: Context,
                        var resource:Int,
                        var items:List<Weightdb>)
    :ArrayAdapter<Weightdb>(mCtx,resource,items){

   internal var db = DBHelper(mCtx)


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View{
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(resource, null)
        val myid: TextView = view.findViewById(R.id.txt_id)
        val myweight: TextView = view.findViewById(R.id.txt_weight)
        val delete: ImageButton = view.findViewById(R.id.btn_delet)
        val dbshow: Weightdb = items[position]
        myid.text = dbshow.id
        myweight.text = dbshow.weightms
        delete.setOnClickListener {
            deletewe(dbshow)}
        return view
           }
    fun deletewe(weightdb: Weightdb) {
        db.deleteweight(weightdb.id)
    }
    }

