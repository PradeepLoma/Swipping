package com.example.testpusher.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.testpusher.data.NewsArticle
import com.example.testpusher.data.getSampleNewsArticles
import com.example.testpusher.utils.detectSwipe
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

/**
 * Created By Pradeep Rai on 4/23/2024.
 */

@Composable
fun HomeScreen(navController: NavHostController) {

    DragGester(data = getSampleNewsArticles())
}

@Composable
fun DragGester(data: List<NewsArticle>) {
    // Using Animatable for smooth vertical transitions
    val offsetY = remember { Animatable(0f) }
    val coroutineScope = rememberCoroutineScope()

    // Current index of the displayed article
    var indexCounter = remember { mutableStateOf(0) }

    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            Modifier
                .offset { IntOffset(x = 0, y = offsetY.value.roundToInt()) }
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectSwipe(
                        onSwipeDown = {
                            if (indexCounter.value > 0) {
                                coroutineScope.launch {
                                    offsetY.animateTo(
                                        targetValue = 1000f,
                                        animationSpec = tween(durationMillis = 600)
                                    )
                                    offsetY.snapTo(0f)
                                    indexCounter.value--
                                }
                            }
                        },
                        onSwipeUp = {
                            if (indexCounter.value < data.size - 1) {
                                coroutineScope.launch {
                                    offsetY.animateTo(
                                        targetValue = -1000f,
                                        animationSpec = tween(durationMillis = 600)
                                    )
                                    offsetY.snapTo(0f)
                                    indexCounter.value++
                                }
                            }
                        },
                        onSwipeLeft = {},
                        onSwipeRight = {}
                    )
                }
        ) {
            AnimatedVisibility(
                visible = true,
                enter = fadeIn() + slideInVertically(initialOffsetY = { it }),
                exit = fadeOut() + slideOutVertically(targetOffsetY = { it })
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .offset(y = offsetY.value.dp)
                ) {
                    Image(
                        painter = painterResource(id = data[indexCounter.value].imageUrl),
                        contentDescription = "News Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .clip(RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        text = data[indexCounter.value].summary,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
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
    }
}



@Preview
@Composable
fun showPreview() {
    DragGester(getSampleNewsArticles())
}
