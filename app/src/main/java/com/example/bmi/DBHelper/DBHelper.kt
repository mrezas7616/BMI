package com.example.bmi.DBHelper

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.bmi.Model.Weightdb

class DBHelper(context:Context)
    :SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VER){
    companion object{
        val DATABASE_VER=1
        val DATABASE_NAME="BMI.db"
        val TBL_DB="TBLWGHT"
        val COL_ID="ID"
        val COL_WGHT="WEIGHT"}
    override fun onCreate(db: SQLiteDatabase?)
    {
        db?.execSQL("create table $TBL_DB (ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"WEIGHT TEXT )")
        Log.i("Reza","table created")}
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
    {
        db?.execSQL("DROP TABLE IF EXISTS $TBL_DB")}
    fun addWeight(w:String)
    {
        val db =this.writableDatabase
        val values = ContentValues()
        values.put(COL_WGHT,w)
        db.insert(TBL_DB,null,values)
        Log.i("REza","data insert")
    }

    val allWeight :Cursor
        get(){
            val db = this.writableDatabase
            val res = db.rawQuery( "SELECT * FROM $TBL_DB", null)
            return res
        }

    fun deleteweight (id:String) :Int {
        val db =this.writableDatabase
        return db.delete(TBL_DB,"$COL_ID=?", arrayOf(id))
    }

}