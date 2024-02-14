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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.zoho.R
import com.example.zoho.models.Post
import com.example.zoho.ui.theme.BACKGROUND
import com.example.zoho.ui.theme.BODY
import com.example.zoho.ui.theme.FONT_BOLD
import com.example.zoho.ui.theme.FONT_REGULAR
import com.example.zoho.ui.theme.NAME
import com.example.zoho.ui.theme.TITLE
import com.example.zoho.ui.theme.White
import com.example.zoho.utils.getCurrentTimeInIST
import com.example.zoho.viewmodels.PostsViewModel

@Composable
fun FeedsScreen() {
    val postsViewModel: PostsViewModel = viewModel()
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
            .padding(
                top = 16.dp,
                bottom = 16.dp
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
                .padding(
                    top = 13.dp,
                    bottom = 16.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween
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
                    .padding(
                        start = 16.dp,
                        end = 24.dp
                    )
                    .weight(1f)
            ) {
                Text(
                    text = posts.title.toString(),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FONT_BOLD,
                        color = TITLE
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.height(50.dp)
                )

                Text(
                    text = posts.body.toString(),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FONT_REGULAR,
                        color = BODY
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .height(50.dp)
                        .padding(top = 6.dp)
                )

                Row (
                    modifier = Modifier.padding(top = 12.dp)
                ) {
                    Text(
                        text = "Devashish",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FONT_REGULAR,
                            color = NAME
                        ),
                        modifier = Modifier.padding(end = 16.dp)
                    )

                    Text(
                        text = getCurrentTimeInIST(),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FONT_REGULAR,
                            color = NAME
                        ),
                    )
                }
            }

            Column(
                modifier = Modifier
                    .padding(end = 40.dp)
            ) {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.ic_like),
                        contentDescription = null,

                    )

                    Text(text = "10",
                        modifier = Modifier.padding( start = 4.dp,
                            top = 8.dp,
                            end = 4.dp)
                    )
                }
                Column (
                    modifier = Modifier.padding(top = 24.dp)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.ic_comment),
                        contentDescription = null,
                    )

                    Text(text = "02",
                        modifier = Modifier.padding( start = 4.dp,
                            top = 8.dp,
                            end = 4.dp))
                }
            }
        }
    }
}

@Composable
@Preview
fun Previewscreen() {
    PostItem(posts = Post(1, 2, "Hello", "World"))
}