package com.hanyeop.mymovieapp.screens.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailsScreen(navController: NavController, movieData: String?) {

    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color.LightGray,
            elevation = 5.dp
        ) {
            Row {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "뒤로가기",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
            }
            Text(text = "Movies")
        }
    }) {
        Text(text = movieData.toString(), style = MaterialTheme.typography.h5)
    }
//    Surface(modifier = Modifier.fillMaxSize()) {
//        Column(horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center) {
//            Text(text = movieData.toString(), style = MaterialTheme.typography.h5)
//
//            Spacer(modifier = Modifier.height(23.dp))
//
//            Button(onClick = { navController.popBackStack() }) {
//                Text(text = "뒤로가라")
//            }
//        }
//    }
}