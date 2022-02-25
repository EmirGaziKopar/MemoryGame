package com.example.memorygame

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.memorygame.R.drawable.*
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.Time

class MainActivity : AppCompatActivity()
{

    //her biri int id'lere sahiptir biz bu id'leri bir diziye aktardık.
    var defaultImageRef = unknown


    var gorseller:MutableList<Int> = mutableListOf(
        //import com.example.memorygame.R.drawable.unknown
        ball , beachball , bubble , comic , fire , football , moon , ok , ball , beachball , bubble , comic , fire , football , moon , ok
    )
    var control = gorseller[0]
    var control1 = gorseller[0]


    var buttonlar : Array<ImageView> = arrayOf()
    var buttonlar2 : Array<ImageView> = arrayOf()

    var score : Int = 0 //basılan 1. ve 2. referanslar aynı mı kontrol etmek için
    var sayac : Int = 0 //her click'de 1 artacak olan sayaç

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonlar = arrayOf(imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12,imageView13,imageView14,imageView15,imageView16)
        buttonlar2 = arrayOf(imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12,imageView13,imageView14,imageView15,imageView16)

        //Buradan gelen her bir button iterator'dır özel bir değişkendir
        //setImageResource ile Image'in kaynağını ayarlayabilir yani değiştirebilirsiniz. Yani ekranda yer alan image'in referansına ulaşarak üzerindeki hangi image'ı göstereceğini belirleyen "@drawable/X" kodundaki X yazan yeri değiştirebilirsiniz.
        buttonlar.forEach { it.setImageResource(defaultImageRef) }
        buttonlar2.forEach { it.setImageResource(defaultImageRef) }

        //Daha önce image'lerimizin id'lerini bir diziye aktarmıştık şimdi ise shuffle ile o id'leri kendi içersinde farklı indekslere atarak karıştırdık.
        //gorseller.shuffle()

        var i = 0;


        object : CountDownTimer(30000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                textView.setText("Time : " + millisUntilFinished / 1000)
            }

            override fun onFinish() {
                textView.setText("done!")
                //Oyunu tekrar oynamak isteyip istemediğini sor
            }
        }.start()

    }


    fun tikla(view : View){
        //Bu kodu yazarak üzerine bastığımız şeyin referansını alırız ve ona dair herşeye ulaşabiliriz.
        var hangiButton:ImageView = view as ImageView

        buttonlar[sayac] = hangiButton
        var hangiButton2:ImageView = view as ImageView
        //Buttonların Int şeklinde tutulan adreslerinin olduğu görseller dizimizi referanslarına ulaşmak içi tekrar kullanıcaz.
        //setImageResource ise aldığımız bu referans değerini .'dan önceki referansı alınan buttona aktaracak böylelikle bastığınız buttona yani referansina ulaştığınız ve ardından da içerisinde yer alan tag'e ulaştığınız buttona alınan tag bilgisine göre kaçıncı indeksteki görsel olduğunu anlayıp o görseli gösterebileceğiz.
        var tmpButton : ImageView = view as ImageView
        var tag = hangiButton.tag.toString().toInt()
        var tagTmp : Int = 0

        hangiButton.setImageResource(gorseller[tag])

        //hangiButton.isClickable = false ilk buttona bastıktan sonra bu kilitlenmeli sonrasında eğer doğru seçimi yaparsa her ikisi de kilitlenmeli ve score 1 artmalı
        //hangiButton.isInvisible = true eğer bulma işlemi gerçekleşirse iki image'de yok edilebilir.
        sayac++;
        if(sayac == 1){
            control = gorseller[tag]
            tagTmp=tag

            tmpButton = hangiButton

        }
        if(sayac == 2){
            control1 = gorseller[tag]
            if(control == control1){
                textView2.text = "score : "+ ++score

                buttonlar[0].isInvisible = true;
                buttonlar[1].isInvisible = true;
                object : CountDownTimer(1500, 1000) {

                    override fun onTick(millisUntilFinished: Long) {
                        buttonlar.forEach {
                            it.isClickable = false
                        }
                    }

                    override fun onFinish() {
                        buttonlar.forEach {
                            it.isClickable = true
                        }

                        buttonlar.forEach { it.setImageResource(defaultImageRef) }
                        //Oyunu tekrar oynamak isteyip istemediğini sor
                    }
                }.start()


                sayac = 0
            }
            else{
                //Buraya girdiğinde zaten 2 defa bastığını anlıyoruz
                object : CountDownTimer(1100, 1000) {

                    override fun onTick(millisUntilFinished: Long) {
                        buttonlar.forEach {
                            it.isClickable = false
                        }
                    }

                    override fun onFinish() {
                        buttonlar.forEach {
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