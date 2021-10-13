package com.hanyeop.composelayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.hanyeop.composelayout.ui.theme.ComposeLayoutTheme
import kotlinx.coroutines.launch

@Composable
fun SimpleColumn() {
    Column {
        repeat(100) {
            Text("Item #$it", style = MaterialTheme.typography.subtitle1)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleColumnPreview() {
    ComposeLayoutTheme {
        SimpleColumn()
    }
}

@Composable
fun SimpleList() {
    // We save the scrolling position with this state
    val scrollState = rememberScrollState()

    Column(Modifier.verticalScroll(scrollState)) {
        repeat(100) {
            Text("Item #$it", style = MaterialTheme.typography.subtitle1)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleListPreview() {
    ComposeLayoutTheme {
        SimpleList()
    }
}

@Composable
fun SimpleLazyList() {
    // We save the scrolling position with this state
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState) {
        items(100) {
            Text("Item #$it", style = MaterialTheme.typography.subtitle1)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleLazyListPreview() {
    SimpleLazyList()
}

@Composable
fun LazyList() {
    // We save the scrolling position with this state
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        item {
            Text(text = "First item")
        }

        // Add 5 items
        items(5) { index ->
            Text(text = "Item: $index")
        }

        // Add another single item
        item {
            Text(text = "Last item")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyListPreview() {
    LazyList()
}


@Composable
fun ImageListItem(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = rememberImagePainter(
                data = "https://developer.android.com/images/brand/Android_Robot.png"
            ),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
//        Surface(
//            modifier = Modifier.size(50.dp),
//            shape = CircleShape,
//            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
//        ) {
//            // Image goes here
//            Image(painter = painterResource(id = R.drawable.ic_baseline_heart_broken_24), contentDescription = "")
//        }
        Spacer(Modifier.width(10.dp))
        Text("Item #$index", style = MaterialTheme.typography.subtitle1)
    }
}

@Preview(showBackground = true)
@Composable
fun ImageListItemPreview() {
    ImageListItem(1)
}

@Composable
fun ImageList() {
    // We save the scrolling position with this state
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState) {
        items(100) {
            ImageListItem(it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ImageListPreview() {
    ImageList()
}

@Composable
fun ScrollingList() {
    val listSize = 100
    // We save the scrolling position with this state
    val scrollState = rememberLazyListState()
    // We save the coroutine scope where our animated scroll will be executed
    val coroutineScope = rememberCoroutineScope()

    Column {
        Row {
            Button(onClick = {
                coroutineScope.launch {
                    // 0 is the first item index
                    scrollState.animateScrollToItem(0)
                }
            }) {
                Text("Scroll to the top")
            }

            Button(onClick = {
                coroutineScope.launch {
                    // listSize - 1 is the last index of the list
                    scrollState.animateScrollToItem(listSize - 1)
                }
            }) {
                Text("Scroll to the end")
            }
        }

        LazyColumn(state = scrollState) {
            items(listSize) {
                ImageListItem(it)
            }
        }
    }
}

@Preview
@Composable
fun ScrollingListPreview() {
    ScrollingList()
}
