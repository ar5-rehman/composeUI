package com.test.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.composeui.ui.theme.ComposeUITheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CustomBox("Android")
                }
            }
        }
    }
}

@Composable
fun CustomBox(name: String) {
    Box(modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center){
        Box(modifier = Modifier
            .width(150.dp)
            .height(150.dp)
            .background(colorResource(id = R.color.teal_700))
            .verticalScroll(rememberScrollState())){
            
            Text(text = name, fontSize = 80.sp)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposeUITheme {
        CustomBox("Android")
    }
}