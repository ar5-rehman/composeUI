package com.test.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.composeui.ui.theme.ComposeUITheme

class TextCustomizationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        TextCustomization()
                        TextAnnotatedCustom()
                        RepeatText()
                    }
                }
            }
        }
    }
}

@Composable
fun TextCustomization() {
    Text(
        text = stringResource(id = R.string.app_name),
        modifier = Modifier
            .background(colorResource(id = R.color.purple_200))
            .padding(12.dp)
            .width(200.dp),
        color = colorResource(id = R.color.white),
        //fontSize = 18.sp,
        fontSize = MaterialTheme.typography.body1.fontSize,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.End
    )

}

@Composable
fun TextAnnotatedCustom(){
    Text( buildAnnotatedString {
        withStyle(style = ParagraphStyle(textAlign = TextAlign.Start)){
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colors.primary,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 15.sp
                )){
                append("A")
            }
            append("B")
            append("C")
            append("D")
        }

    }, modifier = Modifier.width(200.dp))

}

@Composable
fun RepeatText(){
    Text(text = "Abdur".repeat(20), maxLines = 2, overflow = TextOverflow.Ellipsis)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ComposeUITheme {
        Column(modifier = Modifier.fillMaxSize()) {
            TextCustomization()
            TextAnnotatedCustom()
            RepeatText()
        }

    }
}