package net.ezra.ui


import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_GET
import net.ezra.navigation.ROUTE_HOME

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Getstarted(navController: NavHostController) {
    Scaffold(

        content = {
            Box {

                Image(
                    painter = painterResource
                        (id = R.drawable.ma),
                    contentDescription = "Job Inn",
                    modifier = Modifier
                        .fillMaxSize()
//                .clip(CircleShape)
                    ,
                    contentScale = ContentScale.None
                )
            }
        },

        bottomBar = { GottomBar(navController) }
    )
}

@Composable
fun GottomBar(navController: NavHostController) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(elevation = 10.dp) {
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home,"") },
            label = { Text(text = "Get Started") }, selected = (selectedIndex.value == 0), onClick = {
                navController.navigate(ROUTE_HOME) {
                    popUpTo(ROUTE_GET) { inclusive = true }
                }
            }, modifier = Modifier.background(color = Color.Transparent))
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PreviewLight() {
    Getstarted(rememberNavController())
}

