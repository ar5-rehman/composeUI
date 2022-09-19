package com.test.composeui

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.test.composeui.ui.theme.ComposeUITheme
import com.test.composeui.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    //ScaffoldSample()
                    /*Column {
                        CustomText("Abdur, Android Developer")
                        Greeting("Android")
                    }*/
                    CustomSurface()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!",
         fontFamily = FontFamily.SansSerif,
         color = colorResource(R.color.black)
    )
}

@Composable
fun CustomText(text: String){
    Text(text = text,
         style = Typography.h5)
}

@Composable
fun ColumnScope.CustomColumnItem(weight: Float, color: Color = colorResource(id = R.color.black)){
    Surface(modifier = Modifier
        .width(200.dp)
        .height(50.dp),
        //.weight(weight),
        color = color) {}
}

@Composable
fun ColumnScope.CustomWidthMatchParentItem(color: Color = colorResource(id = R.color.black)){
    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(50.dp),
        color = color) {}
}

@Composable
fun RowScope.CustomRowItem(weight: Float, color: Color = colorResource(id = R.color.black)){
    Surface(modifier = Modifier
        .width(50.dp)
        .height(200.dp),
        //.weight(weight),
        color = color) {}
}

@Composable
fun RowScope.CustomRowWidthMatchParentItem(color: Color = colorResource(id = R.color.black)){
    Surface(modifier = Modifier
        .height(200.dp)
        .width(200.dp),
        color = color) {}
}

@Composable
fun CustomSurface(){
   /* Column(modifier = Modifier
        .fillMaxSize()
        .width(500.dp)
        .height(500.dp)
        .background(colorResource(id = R.color.holo_orange_dark)),
        horizontalAlignment = Alignment.CenterHorizontally,
        *//*verticalArrangement = Arrangement.SpaceAround*//*) {

        CustomWidthMatchParentItem(color = colorResource(id = R.color.black))
        CustomColumnItem(weight = 3f, color = colorResource(id = R.color.darker_gray))
    }*/

    Row(modifier = Modifier
        .fillMaxSize()
        .width(500.dp)
        .height(500.dp)
        .background(colorResource(id = R.color.holo_orange_dark)),
        horizontalArrangement = Arrangement.Start,
        /*verticalArrangement = Arrangement.SpaceAround*/) {
        CustomRowWidthMatchParentItem(color = colorResource(id = R.color.black))
        CustomRowItem(weight = 3f, color = colorResource(id = R.color.darker_gray))

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeUITheme {
        //ScaffoldSample()
       /* Column {
            CustomText("Abdur, Android Developer")
            Greeting("Android")
        }*/
        CustomSurface()

    }
}

@Composable
fun ScaffoldSample() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBar(title = {Text("Top App Bar")},backgroundColor = colorResource(id = R.color.black), contentColor = colorResource(
            id = R.color.white
        ))  },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = { FloatingActionButton(onClick = {}){
            Icon(imageVector = Icons.Default.Add, contentDescription = "fab icon")
        } },
        drawerContent = { Text(text = "Drawer Menu 1") },
        content = { Text("Content") },
        bottomBar = { BottomAppBar(backgroundColor = MaterialTheme.colors.primary) { Text("Bottom App Bar") } }
    )
}
