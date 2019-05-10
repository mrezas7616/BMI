package com.example.bmi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ListAdapter
import android.widget.Toast
//import com.example.bmi.AdaptorListView.ListWeightAdaptor
import com.example.bmi.DBHelper.DBHelper
import com.example.bmi.Model.Weightdb
import kotlinx.android.synthetic.main.activity_main.*
import java.nio.file.Files


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        val btn=cal as Button
        val cnt=conter as Button
        btn.setOnClickListener {
            val edittextw=findViewById(R.id.weight) as EditText
            val edittexth=findViewById(R.id.height) as EditText
            var edttxtw:String = edittextw.text.toString()
            var edttxth:String = edittexth.text.toString()
            if(edttxtw.trim().isNotEmpty()&&edttxth.trim().isNotEmpty()) {
                var zero:Double=edttxtw.toDouble()
                var zero1:Double=edttxth.toDouble()
              if (zero == 0.0||zero1==0.0)
                    Toast.makeText(this, "null", Toast.LENGTH_LONG).show()
                else{
                val goToShowBMi = Intent(this, UnderWeight::class.java)
                goToShowBMi.putExtra("Edttxtw", edttxtw)
                goToShowBMi.putExtra("Edttxth", edttxth)
                startActivity(goToShowBMi)}
            }
            else if (edttxtw.trim().isEmpty()) {
                    Toast.makeText(this, "Weight is null", Toast.LENGTH_LONG).show()
                 }
                else if (edttxth.trim().isEmpty()) {
                    Toast.makeText(this, "Height is null", Toast.LENGTH_LONG).show()
                 }

        }
        cnt.setOnClickListener {
            val intent=Intent(this,ShowList::class.java)
            startActivity(intent)
        }
        }

}



