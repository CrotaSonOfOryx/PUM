package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterExample()
                }
            }
        }
    }
}
@Composable
fun CounterExample() {
    var count: Int by remember { mutableStateOf(0) }
    var points: Int by remember { mutableStateOf(0) }
    var pointsTemp=0
    var checked: Int by remember { mutableStateOf(0) }
    var isVisible: Boolean by remember { mutableStateOf(true) }
    val Questions = listOf(
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
    val animatedProgress = animateFloatAsState(
        targetValue = (count.toFloat()*0.1).toFloat(),
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    ).value
    val answers1 = listOf("70C","Gdy zamarza","Masy","Śliwka","Spada","Michael Faraday","Newtona","300 000km/s","Isaac Newton","Amplituda")
    val answers2 = listOf("80C","Gdy wrze","Szybkości","Jabłko","Maleje","Isaac Newton","Arystotelesa","400 000km/s","Albert Einstein","Rodzaj")
    val answers3 = listOf("90C","Gdy się topi","Energii","Kokos","Jest taka sama","Albert Einstein","Archimedesa","500 000km/s","Mikołaj Kopernik","Częstotliwość")
    val answers4 = listOf("100C","Nie zmienia","Siły","Gruszka","Nie wiadomo","James Cook","Pitagorasa","600 000km/s","James Watt","Liczbowa miara wielkości trzęsienia ziemi")
    if (isVisible) {
        var qText = "Pytanie " + (count + 1).toString() + "/10"
        var Question=Questions[count]
        var answer1 = answers1[count]
        var answer2 = answers2[count]
        var answer3 = answers3[count]
        var answer4 = answers4[count]
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = qText,
                fontSize = 25.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(30.dp))
            Column(Modifier.padding(all = 30.dp)) {
                LinearProgressIndicator(progress = animatedProgress)
            }
            Spacer(modifier = Modifier.size(30.dp))
            Card {
                Text(text = Question, fontSize = 25.sp)
            }
            Spacer(modifier = Modifier.size(30.dp))
            Card {
                Column {
                    Row(Modifier.fillMaxWidth()) {
                        RadioButton(selected = checked==1, onClick = {checked=1})
                        Text(text = answer1, fontSize = 25.sp)
                    }
                    Spacer(modifier = Modifier.size(30.dp))
                    Row(Modifier.fillMaxWidth()) {
                        RadioButton(selected = checked==2, onClick ={checked=2})
                        Text(text = answer2, fontSize = 25.sp)
                    }
                    Spacer(modifier = Modifier.size(30.dp))
                    Row(Modifier.fillMaxWidth()) {
                        RadioButton(selected = checked==3, onClick = {checked=3})
                        Text(text = answer3, fontSize = 25.sp)
                    }
                    Spacer(modifier = Modifier.size(30.dp))
                    Row(Modifier.fillMaxWidth()) {
                        RadioButton(selected = checked==4, onClick = {checked=4})
                        Text(text = answer4, fontSize = 25.sp)
                    }
                    Spacer(modifier = Modifier.size(30.dp))
                }
            }
            Column (horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Button(
                    onClick = {
                        if (count==0) {
                            if(checked==1){
                                pointsTemp=10
                            }
                        }
                        else if (count==1) {
                            if(checked==1){
                                pointsTemp=10
                            }
                        }
                        else if (count==2) {
                            if(checked==4){
                                pointsTemp=10
                            }
                        }
                        else if (count==3) {
                            if(checked==2){
                                pointsTemp=10
                            }
                        }
                        else if (count==4) {
                            if(checked==3){
                                pointsTemp=10
                            }
                        }
                        else if (count==5) {
                            if(checked==4){
                                pointsTemp=10
                            }
                        }
                        else if (count==6) {
                            if(checked==3){
                                pointsTemp=10
                            }
                        }
                        else if (count==7) {
                            if(checked==1){
                                pointsTemp=10
                            }
                        }
                        else if (count==8) {
                            if(checked==2){
                                pointsTemp=10
                            }
                        }
                        else if (count==9) {
                            if(checked==4){
                                pointsTemp=10
                            }
                        }
                        count += 1
                        if (count==10){
                            isVisible=false
                        }
                        if (count<10) {
                            qText = "Pytanie " + (count + 1).toString() + "/10"
                            Question=Questions[count]
                            answer1 = answers1[count]
                            answer2 = answers2[count]
                            answer3 = answers3[count]
                            answer4 = answers4[count]
                            points += pointsTemp
                            pointsTemp = 0
                        }
                    }) {
                    Text(text = "Następne", fontSize = 25.sp)
                }
            }
        }
    }
    if(!isVisible){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text ="Gratulacje! Zdobyłeś $points punktów!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        CounterExample()
    }
}

