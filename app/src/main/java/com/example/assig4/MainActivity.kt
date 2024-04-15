package com.example.assig4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assig4.ui.theme.Assig4Theme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assig4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                    }
                }
            }
        }
    }

    @Composable
    fun LemonadeApp() {
        var step by remember { mutableStateOf(Step.LemonTree) }

        when (step) {
            Step.LemonTree -> LemonTreeStep {
                // Navigate to the next step (LemonSqueezeStep)
                step = Step.LemonSqueeze
            }
            Step.LemonSqueeze -> LemonSqueezeStep {
                // Navigate to the next step (DrinkStep)
                step = Step.Drink
            }
            Step.Drink -> DrinkStep {
                // Navigate to the next step (RestartStep)
                step = Step.Restart
            }
            Step.Restart -> RestartStep {
                // Navigate back to the first step (LemonTreeStep)
                step = Step.LemonTree
            }
        }
    }

    @Composable
    fun LemonTreeStep(onClick: () -> Unit) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Tap the lemon tree to select a lemon")
            Spacer(modifier = Modifier.height(32.dp))
            Image(
                painter = painterResource(id = R.drawable.lemon_tree),
                contentDescription = "Lemon tree",
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { onClick() }
            )
        }
    }

    @Composable
    fun LemonSqueezeStep(onClick: () -> Unit) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Keep tapping the lemon to squeeze it")
            Spacer(modifier = Modifier.height(32.dp))
            Image(
                painter = painterResource(id = R.drawable.lemon_squeeze),
                contentDescription = "Lemon",
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { onClick() }
            )
        }
    }

    @Composable
    fun DrinkStep(onClick: () -> Unit) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Enjoy your lemonade!")
            Spacer(modifier = Modifier.height(32.dp))
            Image(
                painter = painterResource(id = R.drawable.lemon_drink),
                contentDescription = "Lemonade",
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { onClick() }
            )
        }
    }

    @Composable
    fun RestartStep(onClick: () -> Unit) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Tap to restart")
            Spacer(modifier = Modifier.height(32.dp))
            Image(
                painter = painterResource(id = R.drawable.lemon_restart),
                contentDescription = "Restart",
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { onClick() }
            )
        }
    }

    enum class Step {
        LemonTree,
        LemonSqueeze,
        Drink,
        Restart
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        Assig4Theme {
            LemonadeApp()
        }
    }