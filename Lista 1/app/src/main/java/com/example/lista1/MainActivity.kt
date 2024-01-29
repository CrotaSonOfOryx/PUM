package com.example.lista1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (count<10){
            countText.text = "Pytanie "+(count+1).toString()+"/10"
            questionText.text=Questions[count]
            answerButton1.text=answers1[count]
            answerButton2.text=answers2[count]
            answerButton3.text=answers3[count]
            answerButton4.text=answers4[count]
            }
        increaseButton.setOnClickListener {
            if (count==0) {
                if(answerButton1.isChecked){
                    pointsTemp=10
                }
            }
            if (count==1) {
                if(answerButton1.isChecked){
                    pointsTemp=10
                }
            }
            if (count==2) {
                if(answerButton4.isChecked){
                    pointsTemp=10
                }
            }
            if (count==3) {
                if(answerButton2.isChecked){
                    pointsTemp=10
                }
            }
            if (count==4) {
                if(answerButton3.isChecked){
                    pointsTemp=10
                }
            }
            if (count==5) {
                if(answerButton4.isChecked){
                    pointsTemp=10
                }
            }
            if (count==6) {
                if(answerButton3.isChecked){
                    pointsTemp=10
                }
            }
            if (count==7) {
                if(answerButton1.isChecked){
                    pointsTemp=10
                }
            }
            if (count==8) {
                if(answerButton2.isChecked){
                    pointsTemp=10
                }
            }
            if (count==9) {
                if(answerButton4.isChecked){
                    pointsTemp=10
                }
            }
            count++
            if (count==10){
                progBar.visibility = View.GONE
                answerButton1.visibility = View.GONE
                answerButton2.visibility = View.GONE
                answerButton3.visibility = View.GONE
                answerButton4.visibility = View.GONE
                countText.visibility = View.GONE
                increaseButton.visibility = View.GONE
                groupButton.visibility = View.GONE
                questionText.text="Gratulacje! Zdobyłeś $points punktów!"
            }
            if (count<10) {
                countText.text = "Pytanie " + (count + 1).toString() + "/10"
                questionText.text = Questions[count]
                progBar.progress = count
                answerButton1.text = answers1[count]
                answerButton2.text = answers2[count]
                answerButton3.text = answers3[count]
                answerButton4.text = answers4[count]
                points += pointsTemp
                pointsTemp = 0
            }
        }

    }
    private val countText: TextView by lazy{findViewById(R.id.count)}
    private var count = 0
    private val increaseButton: Button by lazy { findViewById(R.id.countButton) }
    private val Questions = listOf(
        "W jakiej temperaturze zagotujemy wodę na Mount Everest?",
        "Kiedy objętość wody się zwiększa?",
        "Czego jednostką jest Niuton? ",
        "W zrozumieniu prawa grawitacji podobno pomogło Newtonowi",
        "Jeżeli ciało opada w próżni, to jego prędkość",
        "Który z tych naukowców nie był fizykiem?",
        "„Na każde ciało zanurzone w cieczy działa siła wyporu zwrócona ku górze i równa pod względem wartości ciężarowi wypartej cieczy” – prawo",
        "Prędkość światła wynosi ",
        "Autorem teorii względności jest ",
        "Magnituda to inaczej "
        )
    private val questionText: TextView by lazy { findViewById(R.id.questionText) }
    private val progBar: ProgressBar by lazy{findViewById(R.id.progBar)}
    private val answers1 = listOf("70C","Gdy zamarza","Masy","Śliwka","Spada","Michael Faraday","Newtona","300 000km/s","Isaac Newton","Amplituda")
    private val answers2 = listOf("80C","Gdy wrze","Szybkości","Jabłko","Maleje","Isaac Newton","Arystotelesa","400 000km/s","Albert Einstein","Rodzaj")
    private val answers3 = listOf("90C","Gdy się topi","Energii","Kokos","Jest taka sama","Albert Einstein","Archimedesa","500 000km/s","Mikołaj Kopernik","Częstotliwość")
    private val answers4 = listOf("100C","Nie zmienia","Siły","Gruszka","Nie wiadomo","James Cook","Pitagorasa","600 000km/s","James Watt","Liczbowa miara wielkości trzęsienia ziemi")
    private val answerButton1: RadioButton by lazy { findViewById(R.id.answer1) }
    private val answerButton2: RadioButton by lazy { findViewById(R.id.answer2) }
    private val answerButton3: RadioButton by lazy { findViewById(R.id.answer3) }
    private val answerButton4: RadioButton by lazy { findViewById(R.id.answer4) }
    private var points=0
    private var pointsTemp=0
    private val groupButton: RadioGroup by lazy { findViewById(R.id.group) }
}
