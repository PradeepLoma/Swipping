package com.example.testpusher.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.testpusher.data.NewsArticle
import com.example.testpusher.data.getSampleNewsArticles
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState

/**
 * Created By Pradeep Rai on 4/23/2024.
 */

@Composable
fun SecondScreen(navController: NavHostController) {
    NewsListViewer(data = getSampleNewsArticles(), navController)
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NewsListViewer(
    data: List<NewsArticle>,
    navController: NavController
) {
    val pagerState = rememberPagerState()
    val animation = remember { Animatable(0f) }

    LaunchedEffect(pagerState.currentPage) {
        animation.animateTo(
            targetValue = if (pagerState.currentPage == pagerState.pageCount) 1f else 0f,
            animationSpec = tween(
                durationMillis = 1000,
                easing = LinearOutSlowInEasing
            )
        )
    }

    VerticalPager(
        count = data.size,
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
    ) { page ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
                .offset(
                    x = 0.dp,
                    y = animation.value.dp
                ) // No animation required for Right and left swipe
        ) {
            Image(
                painter = painterResource(id = data[page].imageUrl),
                contentDescription = "Displaying image $page",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)),
                contentScale = ContentScale.FillBounds
            )
            Text(
                text = data[page].summary,
                modifier = Modifier
                    .fillMaxWidth(),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    color = Color.Black,
                    letterSpacing = 1.sp
                )
            )
        }
    }
}


