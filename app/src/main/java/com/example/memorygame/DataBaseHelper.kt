package com.example.memorygame

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.security.AccessControlContext

val tableName = "scores"
val col_id = "id"
val score = "score"
val sure = "sure"



class DataBaseHelper(var context:Context): SQLiteOpenHelper(context, tableName,null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        //run when create to database
        var createTable = " CREATE TABLE "+ tableName +"("+
                col_id +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                score + " INTEGER,"+
                sure + " INTEGER)"
        p0?.execSQL(createTable);
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        // run when upgrade to database
    }

    //We defined function to save data
    fun insertData(gameScores : GameScores){
        val db = this.writableDatabase //I want to write data to database (this is for that)
        val cv = ContentValues() //değişkenleri tutmak için gerekiyor
        // this code add the name of table to database
        cv.put(score,gameScores.score)
        cv.put(sure,gameScores.time)
        
        var sonuc = db.insert(tableName,null,cv)

        if(sonuc == (-1).toLong()){
            Toast.makeText(context,"Hatalı",Toast.LENGTH_LONG).show()
            System.out.println("basarisiz")
        }
        else{
            Toast.makeText(context,"Başarılı",Toast.LENGTH_LONG).show()
            System.out.println("basarili")

        }
    }

    // We define function to read data
    fun readData(): MutableList<GameScores> {
        var list : MutableList<GameScores> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from "+ tableName
        var result = db.rawQuery(query,null)//baslangic degeri null
        if(result.moveToFirst()){ //deger var mı diye kontrol etmek için imleci ilk satırdaki değere doğrulttuk
            do {
                var oyuncu = GameScores()
                oyuncu.time = result.getColumnIndex(sure).toInt()
                oyuncu.score = result.getColumnIndex(score).toInt()
                list.add(oyuncu)


            }while (result.moveToNext())
        }
        result.close()
        db.close()
        return list //listeyi text'de göstermek için return ediyoruz.
    }
}