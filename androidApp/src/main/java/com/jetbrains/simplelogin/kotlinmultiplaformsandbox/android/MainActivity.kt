package com.jetbrains.simplelogin.kotlinmultiplaformsandbox.android

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jetbrains.simplelogin.kotlinmultiplaformsandbox.Greeting
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

//@Composable
//fun MyApplicationTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
//    content: @Composable () -> Unit
//) {
//    val colors = if (darkTheme) {
//        darkColors(
//            primary = Color(0xFFBB86FC),
//            primaryVariant = Color(0xFF3700B3),
//            secondary = Color(0xFF03DAC5)
//        )
//    } else {
//        lightColors(
//            primary = Color(0xFF6200EE),
//            primaryVariant = Color(0xFF3700B3),
//            secondary = Color(0xFF03DAC5)
//        )
//    }
//    val typography = Typography(
//        body1 = TextStyle(
//            fontFamily = FontFamily.Default,
//            fontWeight = FontWeight.Normal,
//            fontSize = 16.sp
//        )
//    )
//    val shapes = Shapes(
//        small = RoundedCornerShape(4.dp),
//        medium = RoundedCornerShape(4.dp),
//        large = RoundedCornerShape(0.dp)
//    )
//
//    MaterialTheme(
//        colors = colors,
//        typography = typography,
//        shapes = shapes,
//        content = content
//    )
//}

class MainActivity : AppCompatActivity() {
    private val scope = MainScope()

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = "Loading..."

        scope.launch {
            kotlin.runCatching {
                Greeting().greeting()
            }.onSuccess {
                tv.text = it
            }.onFailure {
                tv.text = it.localizedMessage
            }
        }
//        setContent {
//            MyApplicationTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                }
//            }
//        }
    }
}

//@Composable
//fun Greeting(text: String) {
//    Text(text = text)
//}

//@Preview
//@Composable
//fun DefaultPreview() {
//    MyApplicationTheme {
//        Greeting("Hello, Android!")
//    }
//}
