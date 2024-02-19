package com.example.zoho.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zoho.R
import com.example.zoho.ui.theme.BACKGROUND
import com.example.zoho.ui.theme.FONT_MEDIUM
import com.example.zoho.ui.theme.FONT_REGULAR
import com.example.zoho.ui.theme.SELECTED_ICON
import com.example.zoho.ui.theme.Toolbar
import com.example.zoho.utils.PostItem
import com.example.zoho.utils.isNetworkOnline
import com.example.zoho.viewmodels.PostsViewModel

@Composable
fun FeedsScreen() {
    val postsViewModel = hiltViewModel<PostsViewModel>()
    postsViewModel.fetchAllPosts()
    val posts = postsViewModel.posts.collectAsState()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = SELECTED_ICON,
                modifier = Modifier
                    .padding(16.dp)
                    .clip(CircleShape)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_plus),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        modifier = Modifier.padding(bottom = 80.dp)
    ) { _ ->
        Column {
            TopBar(
                ascendingOrder = {
                    postsViewModel.sortInAsc()
                },
                descendingOrder = {
                    postsViewModel.sortInDesc()
                }
            )
            LazyColumn(modifier = Modifier.background(BACKGROUND), content = {
                items(posts.value) {
                    PostItem(it) {
                        postsViewModel.updateFavourite(it.id!!)
                    }
                }
            })
        }
    }
}

@Composable
private fun TopBar(ascendingOrder: () -> Unit, descendingOrder: () -> Unit) {
    var isAscending by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Toolbar)
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 24.dp,
                    top = 16.dp,
                    end = 24.dp,
                    bottom = 16.dp
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = "menu",
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier.size(24.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = "Forum",
                        style = TextStyle(
                            fontFamily = FONT_MEDIUM,
                            fontSize = 20.sp,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(start = 24.dp)
                    )
                    Row {
                        Text(
                            text = "All",
                            style = TextStyle(
                                fontFamily = FONT_REGULAR,
                                fontSize = 16.sp,
                                color = Color.White
                            ),
                            modifier = Modifier.padding(start = 24.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_dropdown_arrow),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(Color.White)
                        )
                    }

                }
                Spacer(modifier = Modifier.width(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_sort_icon),
                    contentDescription = "sort",
                    colorFilter = ColorFilter.tint(Color.White),
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            if (isAscending) ascendingOrder.invoke() else descendingOrder.invoke()
                            isAscending = !isAscending
                        }
                        .rotate(if (isAscending) 0f else 180f)
                )
            }
        }
    }
}