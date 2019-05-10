package com.example.bmi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.*
import com.example.bmi.AdaptorListView.ListWeightAdaptor
import com.example.bmi.DBHelper.DBHelper
import com.example.bmi.Model.Weightdb
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_view.*
import kotlinx.android.synthetic.main.under_weight.*
import java.math.RoundingMode
class UnderWeight : AppCompatActivity() {
    internal var db = DBHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.under_weight)
        val weights  = intent.getStringExtra("Edttxtw")
        val height = intent.getStringExtra("Edttxth")
        val showweight = txtw
        val showheight = txth
        val bmishow = txtvbmi
        showweight.text = "" + weights
        showheight.text = "" + height
        bmishow.text=""+calculate(weights,height)
        show(calculate(weights,height))
        //dataa base code
        var btnsave1:Button=findViewById(R.id.btnsave)
        btnsave1.setOnClickListener(){
            db.addWeight(weights)
           Toast.makeText(this,"okey",Toast.LENGTH_LONG).show()

        }
        btnshow.setOnClickListener(){
            val intent=Intent(this,ShowList::class.java)
            startActivity(intent)
        }

    }
    fun calculate(weight:String,height:String ): String {
       var w= weight.toInt()
       var h=height.toFloat()
        h*=h
        var bmi:Float
        bmi=w/h
        val rounded = bmi.toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
        return rounded.toString()

    }
    fun show(calculate:String) {
        var txtdis =txtdis
        var image=bmibackground
        var bmi =calculate.toFloat()
        if (bmi < 18.5) {
          image.setBackgroundResource(R.drawable.underweight)
           txtdis.setText("Extremely dangerous? No, not nescessarily")
        } else if (bmi > 18.5 && bmi < 24.9) {
            image.setBackgroundResource(R.drawable.healthy)
            txtdis.setText("That's good BMI")
        } else if (bmi > 25 && bmi < 29.9) {
            image.setBackgroundResource(R.drawable.overweight)
            txtdis.text=":("
        } else if (bmi >= 30) {
            image.setBackgroundResource(R.drawable.obese)
            txtdis.text="Bad NEWS"
        }
    }

}



