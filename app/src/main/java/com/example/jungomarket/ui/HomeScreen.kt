package com.example.jungomarket.ui

import androidx.compose.ui.graphics.Path
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jungomarket.R.drawable
import com.example.jungomarket.standardQuadFromTo

@ExperimentalFoundationApi
@Composable
fun HomeScreen() {
    Box(
       modifier = Modifier
           .background(Color(0xff06164c))
           .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            chipSection(chips = listOf("Sweet Sleep", "Insomnia", "Depression"))
            currentMeditation()
            featureSection(
                features = listOf(
                    featuredSection(
                        title = "Sleep meditation",
                        drawable.ic_headphone,
                        Color(0xffaeb4fd),
                        Color(0xff9fa5fe),
                        Color(0xff8f98fd)
                    ),

                    featuredSection(
                        title = "Tips for sleeping",
                        drawable.ic_videocam,
                        Color(0xff54e1b6),
                        Color(0xff36ddab),
                        Color(0xff11d79b)
                    ),

                    featuredSection(
                        title = "Night island",
                        drawable.ic_headphone,
                        Color(0xfff0bd28),
                        Color(0xfff1c746),
                        Color(0xfff4cf65)
                    ),

                    featuredSection(
                        title = "Calming Sounds",
                        drawable.ic_headphone,
                        Color(0xfffdbda1),
                        Color(0xfffcaf90),
                        Color(0xfff9a27b)
                    )

                )
            )
        }

        bottomMenu(items = listOf(
            bottomMenuContent("Home", drawable.ic_home),
            bottomMenuContent("Meditation", drawable.ic_bubble),
            bottomMenuContent("Sleep", drawable.ic_sleep),
            bottomMenuContent("Music", drawable.ic_headphone),
            bottomMenuContent("Profile", drawable.ic_profile)
        ), modifier = Modifier.align(Alignment.BottomCenter))

    }
}

@Composable
fun GreetingSection(
    name: String = "Kanu!"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Good Morning!, $name",
                style = MaterialTheme.typography.h5,
                color = Color.White
            )

            Text(
                text = "Have a Good Day!",
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
        }
        Icon(
            painter = painterResource(id = drawable.ic_search),
            contentDescription = "Search",
            modifier = Modifier.size(24.dp),
            tint = Color.White
        )
        
    }
}

@Composable
fun chipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow {
        items(chips.size) {
            Box(modifier = Modifier
                .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                .clickable {
                    selectedChipIndex = it
                }
                .clip(RoundedCornerShape(10.dp))
                .background(
                    if (selectedChipIndex == it) {
                        Color(0xff505cf3)
                    } else {
                        Color(0xff566894)
                    }
                )
                .padding(15.dp)
            ) {
                Text(text = chips[it], color = Color.White)
            }
        }
    }
}

@Composable
fun currentMeditation(
    color: Color = Color(0xfffc879a)
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column {

            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.h5,
                color = Color.White
            )
            Text(
                text = "Meditation, 3-10min",
                style = MaterialTheme.typography.body1,
                color = Color.White
            )

        }

        Box(
          contentAlignment = Alignment.Center,
          modifier = Modifier
              .size(40.dp)
              .clip(CircleShape)
              .background(Color(0xff505cf3))
              .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }

    }
}

@ExperimentalFoundationApi
@Composable
fun featureSection(features: List<featuredSection>){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Features",
            style = MaterialTheme.typography.h5,
            color = Color.White,
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(features.size) {
                featureItem(feature = features[it])
            }
        }
    }
}

@Composable
fun featureItem(
    feature: featuredSection
){
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val height = constraints.maxHeight
        val width = constraints.maxWidth

        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        val lightPoint1 = Offset(0f, height * 0.3f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        Canvas(
            modifier = Modifier
            .fillMaxSize()
        ) {
            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.h6,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(
                text = "Start",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {

                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xff505cf3))
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }

    }
}

@Composable
fun bottomMenu(
    items: List<bottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = Color(0xff505cf3),
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = Color(0xff9aa5c4),
    initialSelectedItemIndex: Int = 0
){
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }

    Row (
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xff06164c))
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, item ->
            bottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun bottomMenuItem(
    item : bottomMenuContent,
    isSelected: Boolean = false,
    activeHighColor: Color = Color(0xff505cf3),
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = Color(0xff9aa5c4),
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box (
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighColor else Color.Transparent)
                .padding(10.dp)
        ){
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if(isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if(isSelected) activeTextColor else inactiveTextColor
        )

    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun preview(){
    HomeScreen()
}