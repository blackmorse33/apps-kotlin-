package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class Review(val text: String, val author: String)

val reviews = listOf(
    Review("Excelente aplicación.", "Usuario A"),
    Review("Muy útil para principiantes.", "Usuario B"),
    Review("Necesita mejoras en la interfaz.", "Usuario C")
)

val categories = listOf(
    "Introducción a la Impresión 3D",
    "Modelado 3D",
    "Calibración de Impresoras",
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyJetpackComposeContent()
        }
    }
}

@Composable
fun MyJetpackComposeContent() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Companion.LightGray)
                .border(2.dp, color = Color.Cyan)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ){
            Text(
                text = "¡DIVERSIÓN CON LA IMPRESIÓN 3D!",
                fontSize = 30.sp
            )
        }

        MyPromoBanner()
        MyCategoryList(categories)

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
            .fillMaxWidth()
            .background(Color.Companion.LightGray)
            .border(2.dp, color = Color.Cyan)
            .padding(horizontal = 16.dp, vertical = 8.dp)
        ){
            Text("COMENTARIOS",
                fontSize = 20.sp
            )

        }

        MyReviewList(reviews)

    }
}



@Composable
fun MyReviewList(reviews: List<Review>) {
    Column {
        reviews.forEach { review ->
            Card(
                modifier = Modifier.fillMaxWidth(),

            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = review.text)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "- ${review.author}")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}




@Composable
fun MyPromoBanner() {
    Card(
        modifier = Modifier.fillMaxWidth(),

    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.ic_launcher_background),
                contentDescription = "imagen de prueba",
                modifier = Modifier.fillMaxWidth()

            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "¡Explora nuestra plataforma de impresión 3D hoy mismo!")
        }
    }
}

@Composable
fun MyCategoryList(categories: List<String>) {
    LazyColumn {
        items(categories) { category ->
            Text(text = category)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyJetpackComposeScreenPreview() {
    MyJetpackComposeContent()
}


