package com.example.memorygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isInvisible
import kotlinx.android.synthetic.main.activity_main.*
import com.example.memorygame.R.drawable.*
import kotlinx.android.synthetic.main.activity_main.imageView
import kotlinx.android.synthetic.main.activity_main.imageView10
import kotlinx.android.synthetic.main.activity_main.imageView11
import kotlinx.android.synthetic.main.activity_main.imageView12
import kotlinx.android.synthetic.main.activity_main.imageView13
import kotlinx.android.synthetic.main.activity_main.imageView14
import kotlinx.android.synthetic.main.activity_main.imageView15
import kotlinx.android.synthetic.main.activity_main.imageView16
import kotlinx.android.synthetic.main.activity_main.imageView2
import kotlinx.android.synthetic.main.activity_main.imageView3
import kotlinx.android.synthetic.main.activity_main.imageView4
import kotlinx.android.synthetic.main.activity_main.imageView5
import kotlinx.android.synthetic.main.activity_main.imageView6
import kotlinx.android.synthetic.main.activity_main.imageView7
import kotlinx.android.synthetic.main.activity_main.imageView8
import kotlinx.android.synthetic.main.activity_main.imageView9
import kotlinx.android.synthetic.main.activity_main.textView
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    var sayacc : Int = 0
    var sure : Int = 0
    var isFinis : Boolean = false
    val yourCountDownTimer = object : CountDownTimer(300000, 1000) {
        override fun onTick(millisUntilFinished: Long)
        {
            textView4.setText("Time : " + millisUntilFinished / 1000)
            sure = (millisUntilFinished/1000).toInt()
        }
        override fun onFinish()
        {
            isFinis = true
            buttonlar.forEach {
                it.isClickable = false

                basicAlert()
            }
        }
    }.start()
    //her biri int id'lere sahiptir biz bu id'leri bir diziye aktard??k.
    var defaultImageRef = R.drawable.unknown //soru i??areti
    var counterVisible : Int = 0
    var complated : Boolean = false

    var gorseller1:MutableList<Int> = mutableListOf(
        //import com.example.memorygame.R.drawable.* import ettigiiz i??in b??yle yazabildik.
        yeni1 , yeni2 , yeni3 , yeni4 , yeni5 , yeni6 , yeni7 , yeni8 , yeni9 , yeni10 , yeni11 , yeni13 , yeni14 , yeni15 , yeni16 , yeni17 , yeni18 , yeni1 , yeni2 , yeni3 , yeni4 , yeni5 , yeni6 , yeni7 , yeni8 , yeni9 , yeni10 , yeni11 , yeni13 , yeni14 , yeni15 , yeni16 , yeni17 , yeni18 , ball , ball
    )

    var control = gorseller1[0]
    var control1 = gorseller1[0]

    var buttonlar : Array<ImageView> = arrayOf()
    var buttonlar2 : Array<ImageView> = arrayOf()

    var score : Int = 0 //bas??lan 1. ve 2. referanslar ayn?? m?? kontrol etmek i??in
    var sayac : Int = 0 //her click'de 1 artacak olan saya??
    var sayac1 : Int = 0 //her click'de her zaman 1 artacak olan saya??
    var score1 : Int = 0



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        lateinit var builder : AlertDialog.Builder
        sayacc = 0
        buttonlar = arrayOf(imageView17,imageView18, imageView19,imageView20,imageView21,imageView22,imageView23,imageView24,imageView25,imageView26,imageView27,imageView28,imageView29,imageView30,imageView31,imageView32,imageView33,imageView34,imageView35,imageView36,imageView37,imageView38,imageView39,imageView40,imageView41,imageView42,imageView43,imageView44,imageView45,imageView46,imageView47,imageView48,imageView49,imageView50,imageView51,imageView52)
        buttonlar2 = arrayOf(imageView17,imageView18, imageView19,imageView20,imageView21,imageView22,imageView23,imageView24,imageView25,imageView26,imageView27,imageView28,imageView29,imageView30,imageView31,imageView32,imageView33,imageView34,imageView35,imageView36,imageView37,imageView38,imageView39,imageView40,imageView41,imageView42,imageView43,imageView44,imageView45,imageView46,imageView47,imageView48,imageView49,imageView50,imageView51,imageView52)

        buttonlar.forEach { it.setImageResource(defaultImageRef) } //Burada img'in default referanslar??
        buttonlar2.forEach { it.setImageResource(defaultImageRef) } //Burada img'in default referanslar??

        gorseller1.shuffle()

        var i = 0;






        //CountDownTimer'??m??z?? burada kullan??yoruz
        yourCountDownTimer

    }


    fun goBack(view: View){
        intent = Intent(this,MainActivity3::class.java);
        finish();
        startActivity(intent);

    }
    fun basicAlert(){
        var Score = score
        var Sure = sure
        if(sayacc == 0){
            val context = this;
            var db = DataBaseHelper(context) //insert i??lemine eri??mek i??in

            System.out.println("oyuncu : "+Score+" "+Sure)
            var oyuncu = GameScores(score,sure)
            db.insertData(oyuncu)
        }

        Toast.makeText(applicationContext,"score: "+score,Toast.LENGTH_LONG).show()
        val builder = AlertDialog.Builder(this)
        sayacc++
        with(builder)
        {
            setTitle("Memory Gameee")
            setMessage("Try again")
            setMessage("Time : "+sure+"sn")
            setPositiveButton("OK"){dialogInterface,it ->
                val intent = intent
                finish()
                startActivity(intent)
                gorseller1.shuffle()
            }
            setNegativeButton("NO"){dialogInterface,it -> finish()}

            show()
        }


    }

    fun tikla2(view : View){
        sayac1++;
        //Bu kodu yazarak ??zerine bast??????m??z ??eyin referans??n?? al??r??z ve ona dair her??eye ula??abiliriz.
        var hangiButton:ImageView = view as ImageView

        buttonlar[sayac] = hangiButton
        var hangiButton2:ImageView = view as ImageView
        //Buttonlar??n Int ??eklinde tutulan adreslerinin oldu??u g??rseller dizimizi referanslar??na ula??mak i??i tekrar kullan??caz.
        //setImageResource ise ald??????m??z bu referans de??erini .'dan ??nceki referans?? al??nan buttona aktaracak b??ylelikle bast??????n??z buttona yani referansina ula??t??????n??z ve ard??ndan da i??erisinde yer alan tag'e ula??t??????n??z buttona al??nan tag bilgisine g??re ka????nc?? indeksteki g??rsel oldu??unu anlay??p o g??rseli g??sterebilece??iz.
        var tmpButton : ImageView = view as ImageView
        var tag = hangiButton.tag.toString().toInt()
        var tagTmp : Int = 0


        textView6.text = "Counter :"+sayac1;
        //hangiButton.isClickable = false ilk buttona bast??ktan sonra bu kilitlenmeli sonras??nda e??er do??ru se??imi yaparsa her ikisi de kilitlenmeli ve score 1 artmal??
        //hangiButton.isInvisible = true e??er bulma i??lemi ger??ekle??irse iki image'de yok edilebilir.
        sayac++;
        if(sayac == 1){
            hangiButton.setImageResource(gorseller1[tag])
            control = gorseller1[tag]
            tagTmp=tag

            tmpButton = hangiButton

        }
        if(sayac == 2){
            hangiButton.setImageResource(gorseller1[tag])
            control1 = gorseller1[tag]
            if(control == control1 && buttonlar[0].id != buttonlar[1].id)
            {


                textView3.text = "Match : "+ ++score1 + "/"+ (gorseller1.count()/2).toString()
                score+=10;
                textView7.text = "Score : "+ score;
                buttonlar[0].isInvisible = true;
                buttonlar[1].isInvisible = true;

                if((gorseller1.count()/2) == score1){

                    Toast.makeText(applicationContext,"score: "+score,Toast.LENGTH_LONG).show()
                    basicAlert()

                    yourCountDownTimer.cancel()
                }

                sayac = 0
            }
            else
            {
                score-=2;
                textView7.text = "Score : "+ score;
                //Buraya girdi??inde zaten 2 defa bast??????n?? anl??yoruz
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