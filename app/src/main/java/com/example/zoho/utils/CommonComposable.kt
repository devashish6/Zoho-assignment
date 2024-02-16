package com.example.zoho.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.zoho.R
import com.example.zoho.models.Post
import com.example.zoho.ui.theme.BACKGROUND
import com.example.zoho.ui.theme.BOLD_POST
import com.example.zoho.ui.theme.REGULAR_POST
import com.example.zoho.ui.theme.USER_TIME_STAMP
import com.example.zoho.ui.theme.White

@Composable
fun PostItem(posts: Post, onClick: () -> Unit = {}) {
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
                val isFavourite by remember { mutableStateOf(posts.favorite) }

                val colorFilter = if (isFavourite) ColorFilter.tint(Color.Red) else null

                Column (
                    modifier = Modifier.clickable {
                        onClick.invoke()
                    }
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_like),
                        contentDescription = null,
                        colorFilter = colorFilter,
                        modifier = Modifier
                            .clickable { onClick.invoke() }
                    )

                    Text(
                        text = "10",
                        modifier = Modifier.padding(start = 4.dp, top = 8.dp, end = 4.dp)
                    )
                }
                Column(
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
fun ActionWithCount(drawableID: Int, count: String, favourite : Boolean = false, onClick: () -> Unit = {}) {
    var isFavourite by remember { mutableStateOf(favourite) }

    val colorFilter = if (isFavourite) ColorFilter.tint(Color.Red) else null
    Image(
        painter = painterResource(id = drawableID),
        contentDescription = null,
        colorFilter = colorFilter,
        modifier = Modifier
            .clickable { onClick.invoke() }
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
