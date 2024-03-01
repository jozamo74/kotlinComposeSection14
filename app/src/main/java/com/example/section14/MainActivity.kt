package com.example.section14

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import com.example.section14.ui.theme.Section14Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Section14Theme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize().background(Color(0xFF161D26)),

                ) {
                    TwitterCard()
                    TwitDivider()
                    TwitterCard()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TwitterCard() {

    var chat by remember {
        mutableStateOf(false)
    }

    var rt by remember {
        mutableStateOf(false)
    }

    var like by remember {
        mutableStateOf(false)
    }

    Section14Theme {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF161D26))
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(55.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    TextTitle(title = "Jzm", modifier = Modifier.padding(end = 8.dp))
                    TextDefault(title = "@Jozamo", modifier = Modifier.padding(end = 8.dp))
                    TextDefault(title = "4h", modifier = Modifier.padding(end = 8.dp))
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        painterResource(id = R.drawable.ic_dots),
                        contentDescription = "",
                        tint = Color.White,
                    )
                    /*Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.End) {
                        Icon(
                            painterResource(id = R.drawable.ic_dots),
                            contentDescription = "",
                            tint = Color.White,
                            )
                    }*/
                }
                TextBody(
                    title = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. ",
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(10)),
                    contentScale = ContentScale.Crop

                )

                Row(modifier = Modifier.padding(top = 16.dp)) {
                    SocialIcon(
                        modifier = Modifier.weight(1f),
                        unselectedIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_chat),
                                contentDescription = "",
                                tint = Color(0xFF7E8B98)
                            )

                        },
                        selectedIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_chat_filled),
                                contentDescription = "",
                                tint = Color(0xFF7E8B98)
                            )
                        },
                        isSelected = chat,
                        onItemSelected = { chat = !chat }
                    )

                    SocialIcon(
                        modifier = Modifier.weight(1f),
                        unselectedIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_rt),
                                contentDescription = "",
                                tint = Color(0xFF7E8B98)
                            )

                        },
                        selectedIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_rt),
                                contentDescription = "",
                                tint = Color(0xFF00FF27)
                            )
                        },
                        isSelected = rt,
                        onItemSelected = { rt = !rt }
                    )

                    SocialIcon(
                        modifier = Modifier.weight(1f),
                        unselectedIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_like),
                                contentDescription = "",
                                tint = Color(0xFF7E8B98)
                            )

                        },
                        selectedIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_like_filled),
                                contentDescription = "",
                                tint = Color(0xFFFF0000)
                            )
                        },
                        isSelected = like,
                        onItemSelected = { like = !like }
                    )
                }

            }
        }
    }
}

@Composable
fun SocialIcon(
    modifier: Modifier,
    unselectedIcon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit,
    isSelected: Boolean,
    onItemSelected: () -> Unit
) {
    val defaultValue = 1

    Row(
        modifier = modifier.clickable { onItemSelected() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isSelected) selectedIcon() else unselectedIcon()

        Text(
            text = if (isSelected) (defaultValue + 1).toString() else defaultValue.toString(),
            color = Color(0xFF7E8B98),
//            fontSize = 12.dp,
            modifier = modifier.padding(start = 4.dp)
        )
    }
}

@Composable
fun TextBody(title: String, modifier: Modifier = Modifier) {
    Text(text = title, color = Color.White, modifier = modifier)
}

@Composable
fun TextTitle(title: String, modifier: Modifier = Modifier) {
    Text(text = title, color = Color.White, fontWeight = FontWeight.ExtraBold, modifier = modifier)
}

@Composable
fun TextDefault(title: String, modifier: Modifier = Modifier) {
    Text(text = title, color = Color.Gray, modifier = modifier)
}

@Preview
@Composable
fun TwitDivider(){
    Divider(
        modifier = Modifier
            .padding(top = 4.dp)
            .height(0.5.dp)
            .fillMaxWidth(),
        color = Color(0xFF7E8B98)
    )
}