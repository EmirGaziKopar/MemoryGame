package com.example.memorygame

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import com.example.memorygame.R.drawable.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity : AppCompatActivity()
{
    var sure : Int = 0
    var sayacc : Int = 0
    val yourCountDownTimer = object : CountDownTimer(30000, 1000) {
        override fun onTick(millisUntilFinished: Long)
        {
            textView.setText("Time : " + millisUntilFinished / 1000)
            sure = (millisUntilFinished/1000).toInt()
        }
        override fun onFinish()
        {
            buttonlar.forEach {
                it.isClickable = false
                basicAlert()
            }
        }
    }.start()
    //her biri int id'lere sahiptir biz bu id'leri bir diziye aktardık.
    var defaultImageRef = unknown //soru işareti
    var counterVisible : Int = 0
    var complated : Boolean = false
    var gorseller:MutableList<Int> = mutableListOf(
        //import com.example.memorygame.R.drawable.unknown
        ball , beachball , bubble , comic , fire , football , moon , ok , ball , beachball , bubble , comic , fire , football , moon , ok
    )
    var control = gorseller[0]
    var control1 = gorseller[0]


    var buttonlar : Array<ImageView> = arrayOf()
    var buttonlar2 : Array<ImageView> = arrayOf()
    var score1 : Int = 0
    var score : Int = 0 //basılan 1. ve 2. referanslar aynı mı kontrol etmek için
    var sayac : Int = 0 //her click'de 1 artacak olan sayaç
    var sayac1 : Int = 0 //her click'de her zaman 1 artacak olan sayaç
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var builder : AlertDialog.Builder
        sayacc = 0
        buttonlar = arrayOf(imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12,imageView13,imageView14,imageView15,imageView16)
        buttonlar2 = arrayOf(imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12,imageView13,imageView14,imageView15,imageView16)

        //Buradan gelen her bir button iterator'dır özel bir değişkendir
        //setImageResource ile Image'in kaynağını ayarlayabilir yani değiştirebilirsiniz. Yani ekranda yer alan image'in referansına ulaşarak üzerindeki hangi image'ı göstereceğini belirleyen "@drawable/X" kodundaki X yazan yeri değiştirebilirsiniz.
        buttonlar.forEach { it.setImageResource(defaultImageRef) } //Burada img'in default referansları
        buttonlar2.forEach { it.setImageResource(defaultImageRef) } // bütün resimleri soru işareti yaptık

        //Daha önce image'lerimizin id'lerini bir diziye aktarmıştık şimdi ise shuffle ile o id'leri kendi içersinde farklı indekslere atarak karıştırdık.
        gorseller.shuffle()

        var i = 0;

        //CountDownTimer'ımızı burada kullanıyoruz
        yourCountDownTimer


        //2.YOL
        /*object : CountDownTimer (30000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                textView.setText("Time : " + millisUntilFinished / 1000)
            }

            override fun onFinish() {
                buttonlar.forEach {
                    it.isClickable = false
                    basicAlert()
                }
                //Oyunu tekrar oynamak isteyip istemediğini sor
            }
        }.start()*/

    }

    fun goBack(view: View){
        intent = Intent(this,MainActivity3::class.java);
        finish()
        startActivity(intent);
    }

    fun basicAlert(){
        if(sayacc==0){
            val context = this;
            var db = DataBaseHelper(context) //insert işlemine erişmek için
            System.out.println("oyuncu : "+score+" "+sure)
            var oyuncu = GameScores(score,sure)
            db.insertData(oyuncu)
        }

        Toast.makeText(applicationContext,"score: "+score, Toast.LENGTH_LONG).show()
        val builder = AlertDialog.Builder(this)
        sayacc++
        with(builder)
        {
            setTitle("Memory Gameee")
            setMessage("Try again")
            setMessage("Score : "+sure+"sn")
            setPositiveButton("OK"){dialogInterface,it ->
                val intent = intent
                finish()
                startActivity(intent)
                gorseller.shuffle()
            }
            setNegativeButton("NO"){dialogInterface,it -> finish()}

            show()
        }


    }


    fun tikla(view : View){
        //sayac1++;
        textView5.text = "Counter: "+ ++sayac1;
        //Bu kodu yazarak üzerine bastığımız şeyin referansını alırız ve ona dair herşeye ulaşabiliriz.
        var hangiButton:ImageView = view as ImageView

        buttonlar[sayac] = hangiButton
        var hangiButton2:ImageView = view as ImageView
        //Buttonların Int şeklinde tutulan adreslerinin olduğu görseller dizimizi referanslarına ulaşmak içi tekrar kullanıcaz.
        //setImageResource ise aldığımız bu referans değerini .'dan önceki referansı alınan buttona aktaracak böylelikle bastığınız buttona yani referansina ulaştığınız ve ardından da içerisinde yer alan tag'e ulaştığınız buttona alınan tag bilgisine göre kaçıncı indeksteki görsel olduğunu anlayıp o görseli gösterebileceğiz.
        var tmpButton : ImageView = view as ImageView
        var tag = hangiButton.tag.toString().toInt()
        var tagTmp : Int = 0



        //hangiButton.isClickable = false ilk buttona bastıktan sonra bu kilitlenmeli sonrasında eğer doğru seçimi yaparsa her ikisi de kilitlenmeli ve score 1 artmalı
        //hangiButton.isInvisible = true eğer bulma işlemi gerçekleşirse iki image'de yok edilebilir.
        sayac++;
        if(sayac == 1){
            hangiButton.setImageResource(gorseller[tag])
            control = gorseller[tag]
            tagTmp=tag

            tmpButton = hangiButton

        }
        if(sayac == 2){
            hangiButton.setImageResource(gorseller[tag])
            control1 = gorseller[tag]
            if(control == control1 && buttonlar[0].id != buttonlar[1].id)
            {
                textView2.text = "Match : "+ ++score1 + "/" + (gorseller.count()/2).toString()
                score+=10;
                textView10.text = "Score :"+ score;
                buttonlar[0].isInvisible = true;
                buttonlar[1].isInvisible = true;

                /*
                buttonlar.drop(0);
                buttonlar.drop(0);
                listeden çıkar ki tekrar dönmesin
                */
                if((gorseller.count()/2) == score1){
                    basicAlert()
                    yourCountDownTimer.cancel()
                }

                sayac = 0
            }
            else
            {
                score-=2;
                textView10.text = "Score :"+ score;
                //Buraya girdiğinde zaten 2 defa bastığını anlıyoruz
                object : CountDownTimer(1050, 1000) {

                    override fun onTick(millisUntilFinished: Long) {

                        buttonlar2.forEach {
                            it.isClickable = false
                        }
                    }

                    override fun onFinish() {

                        buttonlar2.forEach {
                            it.isClickable = true
                        }
                        buttonlar.forEach { it.setImageResource(defaultImageRef) }
                    }
                }.start()
                sayac = 0


            }
        }




    }



}