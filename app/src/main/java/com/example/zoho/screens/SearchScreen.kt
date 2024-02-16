package com.example.zoho.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zoho.DEFAULT_SEARCH
import com.example.zoho.R
import com.example.zoho.ui.theme.BACKGROUND
import com.example.zoho.ui.theme.SEARCH_BAR_TEXT
import com.example.zoho.ui.theme.SEARCH_TINT
import com.example.zoho.ui.theme.Toolbar
import com.example.zoho.utils.PostItem
import com.example.zoho.viewmodels.PostsViewModel

@Composable
fun SearchScreen() {
    val postsViewModel = hiltViewModel<PostsViewModel>()
    val posts = postsViewModel.filteredPosts.collectAsState()

    Scaffold {_->
        Column {
            CustomSearchBar(
                onSearch = {
                    postsViewModel.searchPosts(it)
                }
            )
            LazyColumn(modifier = Modifier.background(BACKGROUND), content = {
                items(posts.value) {
                    PostItem(it)
                }
            })
        }
    }
}

@Composable
fun CustomSearchBar(onSearch: (String) -> Unit) {
    var searchText by remember { mutableStateOf("") }
    var isHintDisplayed by remember {
        mutableStateOf(true)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Toolbar)
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, top = 12.dp, bottom = 12.dp, end = 8.dp)
        ) {
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 18.dp, bottom = 18.dp, end = 16.dp)
            ) {
                BasicTextField(value = searchText,
                    onValueChange = {
                        searchText = it
                        isHintDisplayed = searchText.isEmpty()
                        onSearch(it)
                    },
                    maxLines = 1,
                    singleLine = true,
                    textStyle = SEARCH_BAR_TEXT,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                if (isHintDisplayed) {
                    Text(text = DEFAULT_SEARCH)
                }
                Image(
                    painter = painterResource(id = R.drawable.ic_search), contentDescription = null,
                    colorFilter = ColorFilter.tint(SEARCH_TINT),
                    modifier = Modifier.align(Alignment.CenterEnd)

                )
            }
        }

    }
}