package com.example.jungomarket.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonColors
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jungomarket.R

@Composable
fun homeScreen() {
    Box(
       modifier = Modifier
           .background(Color(0xff06164c))
           .fillMaxSize()
    ) {
        Column {
            greetingSection()
            chipSection(chips = listOf("Sweet Sleep", "Insomnia", "Depression"))
        }

    }
}

@Composable
fun greetingSection(
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
                style = MaterialTheme.typography.h3,
                color = Color.White
            )

            Text(
                text = "Have a Good Day!",
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
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
    color: Color
){

}

@Preview
@Composable
fun preview(){
    homeScreen()
}