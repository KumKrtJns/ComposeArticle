package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeArticleWithImage(getString(R.string.title),getString(R.string.shrtDes),getString(
                                            R.string.LngDes))
                }
            }
        }
    }
}

@Composable
fun ComposeArticleWithImage(title: String, shrtDes: String, LngDes: String,modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.bg_compose_background)
    Column {
        Image(painter = image,
              contentDescription = null,
              modifier = Modifier.fillMaxWidth()
        )
        ComposeArticleWithText(title, shrtDes, LngDes)
    }


}

@Composable
fun ComposeArticleWithText(title:String, shrtDes:String, LngDes:String,modifier: Modifier = Modifier) {
    Column {
        Text(text = title, fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Text(text = shrtDes,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        )
        Text(text = LngDes,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun ComposeArticlePreview() {
    ComposeArticleTheme {
        ComposeArticleWithImage("Android", "kumar","kumar" )
    }
}