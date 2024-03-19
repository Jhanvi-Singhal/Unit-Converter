package com.example.unitconverter

import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                       UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter(){
    var inputValue by remember{mutableStateOf(value =" " ) }
    var outputValue by remember{mutableStateOf(value =" " ) }
    var iUnit by remember{mutableStateOf(value ="Meters" ) }
    var oUnit by remember{mutableStateOf(value ="Meters" ) }
    var iMenu by remember{mutableStateOf(value =false) }
    var oMenu by remember{mutableStateOf(value =false ) }
    var iCF by remember{mutableStateOf(value = 1.0) }
    var oCF by remember{mutableStateOf(value = 1.0) }

     fun calculate(){
          val iVal = inputValue.toDoubleOrNull() ?: 0.0
         val oVal = (iVal * iCF * oCF )
         outputValue= oVal.toString()
     }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally


    ){
        Text(text = "Unit Converter", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = inputValue, onValueChange ={
            inputValue = it
            calculate()
        }, label = {Text(text = "Enter Value") })
        Spacer(modifier = Modifier.height(16.dp))
        Row{
           Box {
               Button(onClick = { /*TODO*/iMenu=true}) {
                   Text(text = iUnit)
                   Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
               }
               DropdownMenu(expanded = iMenu, onDismissRequest = { iMenu= false }) {
                   DropdownMenuItem(text = { Text(text = "Meters")},
                       onClick = {iMenu=false
                                   iUnit="Meters"
                                   iCF=1.0
                       calculate()})
                   DropdownMenuItem(text = { /*TODO*/Text(text = "Centimeters") }, onClick = { iMenu=false
                       iUnit="Centimeters"
                       iCF=0.01
                       calculate()})
                   DropdownMenuItem(text = { /*TODO*/Text(text = "Millimeters") }, onClick = { iMenu=false
                       iUnit="Millimeters"
                       iCF=0.001
                       calculate()})
                   DropdownMenuItem(text = { /*TODO*/Text(text = "Kilometers") }, onClick = { iMenu=false
                       iUnit="Kilometers"
                       iCF=1000.0
                       calculate()})
               }
           }
            Spacer(modifier = Modifier.height(16.dp))
            Box {
                Button(onClick = { /*TODO*/oMenu=true }) {
                    Text(text = oUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = oMenu, onDismissRequest = { /*TODO*/oMenu=false }) {
                    DropdownMenuItem(text = { Text(text = "Meters")}, onClick = { /*TODO*/
                        oMenu=false
                        oUnit="Meters"
                        oCF=1.0
                        calculate()})
                    DropdownMenuItem(text = { /*TODO*/Text(text = "Centimeters") }, onClick = {  oMenu=false
                        oUnit="Centimeters"
                        oCF=100.0
                        calculate()})
                    DropdownMenuItem(text = { /*TODO*/Text(text = "Millimeters") }, onClick = {  oMenu=false
                        oUnit="Millimeters"
                        oCF=1000.0
                        calculate()})
                    DropdownMenuItem(text = { /*TODO*/Text(text = "Kilometers") }, onClick = {  oMenu=false
                        oUnit="Kilometers"
                        oCF=0.001
                        calculate()})
                }
            }
            }

    Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Result: $outputValue $oUnit" , style = MaterialTheme.typography.headlineMedium)
    }}


@Preview(showBackground =true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}



