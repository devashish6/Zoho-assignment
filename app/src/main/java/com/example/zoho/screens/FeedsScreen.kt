package com.example.zoho.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.zoho.R
import com.example.zoho.models.Post
import com.example.zoho.ui.theme.BACKGROUND
import com.example.zoho.ui.theme.BOLD_POST
import com.example.zoho.ui.theme.REGULAR_POST
import com.example.zoho.ui.theme.USER_TIME_STAMP
import com.example.zoho.ui.theme.White
import com.example.zoho.utils.getCurrentTimeInIST
import com.example.zoho.viewmodels.PostsViewModel

@Composable
fun FeedsScreen(navController: NavHostController) {
    val postsViewModel = hiltViewModel<PostsViewModel>()
    val posts = postsViewModel.posts.collectAsState()
    LazyColumn(modifier = Modifier.background(BACKGROUND), content = {
        items(posts.value) {
            PostItem(it)
        }
    })
}

@Composable
fun PostItem(posts: Post) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(BACKGROUND)
            .padding(top = 16.dp, bottom = 16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
                .padding(top = 13.dp, bottom = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .width(50.dp)
            )

            Column(
                modifier = Modifier
                    .padding(start = 16.dp, end = 24.dp)
                    .weight(1f)
            ) {

                CardComposableText(
                    text = posts.title.toString(),
                    style = BOLD_POST,
                    modifier = Modifier.height(50.dp)
                )

                CardComposableText(
                    text = posts.body.toString(),
                    style = REGULAR_POST,
                    modifier = Modifier
                        .height(50.dp)
                        .padding(top = 6.dp)
                )

                Row(
                    modifier = Modifier.padding(top = 12.dp)
                ) {
                    CardComposableText(
                        text = "Devashish",
                        style = USER_TIME_STAMP,
                        modifier = Modifier.padding(end = 16.dp)
                    )

                    CardComposableText(
                        text = getCurrentTimeInIST(),
                        style = USER_TIME_STAMP,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .padding(end = 40.dp)
            ) {
                Column {
                    ActionWithCount(R.drawable.ic_like, "10")
                }
                Column (
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    ActionWithCount(
                        drawableID = R.drawable.ic_comment,
                        count = "02"
                    )
                }
            }
        }
    }
}

@Composable
fun ActionWithCount(drawableID: Int, count: String) {
    Image(
        painter = painterResource(id = drawableID),
        contentDescription = null,
    )

    Text(
        text = count,
        modifier = Modifier.padding(start = 4.dp, top = 8.dp, end = 4.dp)
    )

}

@Composable
fun CardComposableText(text: String, style: TextStyle, modifier: Modifier = Modifier) {
    return Text(
        text = text,
        style = style,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier
    )
}