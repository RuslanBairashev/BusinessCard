package com.ruba.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ruba.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier.background(Color(0xFF66CDAA))
    ) {
        Column(
            Modifier.weight(0.7f)
        ) {
            MainInfo()
        }
        Column(
            Modifier.weight(0.3f)
        ) {
            ContactInfo(
                stringResource(id = R.string.phone_number),
                painterResource(id = R.drawable.ic_phone),
                Modifier.weight(1f)
            )
            ContactInfo(
                stringResource(id = R.string.tg_link),
                painterResource(id = R.drawable.ic_link),
                Modifier.weight(1f)
            )
            ContactInfo(
                stringResource(id = R.string.email),
                painterResource(id = R.drawable.ic_email),
                Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun MainInfo(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_photo),
            contentDescription = null,
            modifier = Modifier.padding(top = 16.dp).scale(0.75f)
        )
        Text(
            stringResource(id = R.string.full_name),
            textAlign = TextAlign.Justify,
            fontSize = 24.sp,
            fontWeight = Bold
        )
        Text(
            stringResource(id = R.string.title),
            textAlign = TextAlign.Justify,
            fontSize = 18.sp,
            color = Color.DarkGray,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
fun ContactInfo(
    text: String,
    image: Painter,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxSize()
            .padding(start = 60.dp)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.scale(0.5f)
        )
        Text(
            text,
            modifier= Modifier

        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}