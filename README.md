# MemoryGame
![zor](https://user-images.githubusercontent.com/75802906/163713817-0855f127-2afe-4a6c-aa87-768f5ab4e7d5.gif)
![orta](https://user-images.githubusercontent.com/75802906/163713825-3980d48b-a0bc-4c13-b142-63da6787590e.gif)
![Başlıksız-1](https://user-images.githubusercontent.com/75802906/163725726-90f212b5-6938-4b08-a3b0-082e604ace29.jpg)


**AÇIKLAMA**

 Oyunun başında  "import com.example.memorygame.R.drawable.* "  diyerek mutable list içerisinden bütün resimlerin değerlerine isimlerini kullanarak ulaştık.



Sonrasında grid üzerinde resimlerimizi göstermek için kullandığımız ImageView array'indeki tüm resimlere ulaşıp "setImageResource" ile default olarak belirlediğimiz resmimizin değerini tüm buttonlara atadık ve tüm buttonlar

Soru işareti img'ine dönüştü. Oyunun oynanışı sırasında resimlerin tamamı bulunamaması durumunda

sonsuza kadar devam ederek oynayana psikolojik bir yara vermemesi için CountDownTimer kullanarak bitirilmesi gereken bir süre belirledik.

Her buttonun içerisine bir tag değeri atadık ve bu tagler sayesinde "var hangiButton:ImageView = view as ImageView" ardında da "var tag = hangiButton.tag.toString().toInt()" de diyerek

referansina ulaştığınız ve ardından da içerisinde yer alan tag'e ulaştığınız buttona alınan tag bilgisine göre kaçıncı indeksteki görsel olduğunu anlayıp o görseli gösterdik.

Sonrasında kodun içerisine sayaç yerleştirerek sayac == 1 olduğunda birinci basılan resmin değerini sayac == 2 olduğunda ise


2. basılan resmin referans değerini ve birinciyle aynı olup olmadığını kontrol ederek eğer aynıysa ve id'değerleri de farklıysa isInvisible = true yaptık ve bulunan resimleri yok ettik

Yani kullanıcının aynı resme iki kere basması durumunda score yazmaması için id değerlerinin farklı olması şartını koda ekledik.

Ayrıca oyun başında görsellerin referans değerlerinin grid üzerinde rastgele dağılabilmesi için gorseller.shuffle() diyerek

görsellerin referans değerleini tutan diziyi karıştırdık. Her eşleşmede score'u belirtildiği şekilde artırdık. Yanlış eşleşme durumundaysa

default değerini vererek kapattık ve score değerini belirtildiği miktarda azalttık. Oyun bitişinde süre ve score gibi değerleri içerisine read,insert,create gibi komutları olan

DatabaseHelper'ı yazarak oyun sonlarında score'u kaydetmesi için kullandık. Kaydedilen score'ları listelerken textView kullandık. Ayrıca oyunun başında

medium seçmeniz halinde 4x4 , hard seçmeniz halinde 6x6 olan aktivite ekranları sunduk. Ekrandaki görselleri grid layout kullanarak dizdik.

