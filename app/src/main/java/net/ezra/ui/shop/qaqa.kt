package net.ezra.ui.shop

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.navigation.ROUTE_GET
import net.ezra.navigation.ROUTE_QAQA


@Composable
fun QaqaScreen(title: String.Companion, navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())

    ) {

        var expanded by remember { mutableStateOf(false) }

        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(10.dp)
                .size(width = 300.dp, height = 250.dp)
                .clickable { run { expanded = !expanded } }


        ) {
            Column(
            ) {
                (
                        Text(
                            text = "Title",
                            style = MaterialTheme.typography.displayLarge,
                            modifier = Modifier.padding(8.dp)
                        ))
                if (expanded) {
                    Text(
                        text = "Content Sample for Display on Expansion of Card",
                        style = MaterialTheme.typography.displayMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(100.dp))
//    Column(
//
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
//    ){
//        Button(
//            onClick = {
//                navController.navigate(ROUTE_HOME) {
//                    popUpTo(ROUTE_QAQA) { inclusive = true }
//                }
//            },
//            shape = RoundedCornerShape(10.dp),
//            colors = ButtonDefaults.outlinedButtonColors(Color(0xff5bb4fa)),
//            border = BorderStroke(1.5.dp, Color.Transparent),
//            contentPadding = PaddingValues(15.dp),
//            modifier = Modifier
//                .height(50.dp)
//                .width(150.dp),
//        ) {
//            Text("Get Started", color = Color.Black)
//        }
//    }

    Row(

    ){
        Button(
            onClick = {
                navController.navigate(ROUTE_GET) {
                    popUpTo(ROUTE_QAQA) { inclusive = true }
                }
            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.outlinedButtonColors(Color(0xff5bb4fa)),
            border = BorderStroke(1.5.dp, Color.Transparent),
            contentPadding = PaddingValues(15.dp),
            modifier = Modifier
                .height(50.dp)
                .width(150.dp),
        ) {
            Text("Get Started", color = Color.Black)
        }
    }
}
fun NavHostController.navigateWithPopUp(
    toRoute: String,  // route name where you want to navigate
    fromRoute: String // route you want from popUpTo.
) {
    this.navigate(toRoute) {
        popUpTo(fromRoute) {
            inclusive = true // It can be changed to false if you
            // want to keep your fromRoute exclusive
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    QaqaScreen(title = String, rememberNavController())
}