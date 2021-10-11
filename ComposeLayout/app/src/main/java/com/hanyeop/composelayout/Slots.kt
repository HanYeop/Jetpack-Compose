package com.hanyeop.composelayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hanyeop.composelayout.ui.theme.ComposeLayoutTheme

@Composable
fun createButton(){
    Button(onClick = { /*TODO*/ }) {
        Row(){
            Image(painter = painterResource(id = R.drawable.ic_baseline_heart_broken_24), contentDescription = "")
            Text(
                "버튼",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun buttonPreview(){
    ComposeLayoutTheme {
        createButton()
    }
}