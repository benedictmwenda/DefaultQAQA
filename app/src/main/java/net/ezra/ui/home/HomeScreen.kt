 package net.ezra.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_ADD_STUDENTS
import net.ezra.navigation.ROUTE_CONTACT
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_MENU
import net.ezra.navigation.ROUTE_SEARCH


 @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
 @Composable
fun HomeScreen(navController: NavHostController) {
     Scaffold(

         topBar = {
             TopAppBar(
                 title = {
                     Text(text = "Job Inn")
                 },
                 navigationIcon = {
                     IconButton(onClick = {
                         navController.navigate(ROUTE_MENU) {
                             popUpTo(ROUTE_HOME) { inclusive = true }
                         }
                     }) {
                         Icon(Icons.Filled.Menu, "menu")
                     }
                 },
                 backgroundColor = MaterialTheme.colorScheme.background,
                 contentColor = Color.Transparent,
                 elevation = 20.dp
             )
         },


         content = {
             Box(
                 modifier = Modifier
                     .background(color = Color.White)
                     .verticalScroll(rememberScrollState())
             ) {



                         // background Images


                         Image(painter = painterResource
                             (id = R.drawable.ma),
                             contentDescription = "Job Inn",
                             modifier = Modifier
                                 .fillMaxSize()
//                .clip(CircleShape)
                             ,
                             contentScale = ContentScale.None
                         )


                         //Profile pic, search Button


                         Column(
                             modifier = Modifier
                                 .padding(10.dp),
                         ) {
                             Spacer(modifier = Modifier.height(50.dp))
                             Row(
                                 horizontalArrangement = Arrangement.SpaceAround,
                                 modifier = Modifier
                                     .background(color = Color.Transparent)
                             ) {

                                 Text(text = "Find your big dream job",
                                     style = TextStyle(
                                         color = Color.Black,
                                         fontSize = 35.sp,
                                         fontFamily = FontFamily.SansSerif,
                                         fontWeight = FontWeight.W700,
                                         fontStyle = FontStyle.Normal,
                                         letterSpacing = 0.1.em,
                                         background = Color.Transparent,
                                         textDecoration = TextDecoration.None
                                     ))

                             }
                             Row(
                                 verticalAlignment = Alignment.CenterVertically,

                                 ) {
                                 Button(
                                     onClick = {
                                         navController.navigate(ROUTE_SEARCH) {
                                             popUpTo(ROUTE_HOME) { inclusive = true }
                                         }
                                     },
                                     shape = RoundedCornerShape(50.dp),
                                     colors = ButtonDefaults.outlinedButtonColors(Color.White),
                                     border = BorderStroke(1.5.dp, Color.Transparent),
                                     contentPadding = PaddingValues(15.dp),
                                     ) {
                                     Row(
                                         modifier = Modifier
                                             .size(width = 300.dp, height = 30.dp)
                                             .border(
                                                 width = 1.5.dp,
                                                 color = Color.DarkGray,
                                                 shape = CircleShape
                                             )
                                             .padding(5.dp)

                                     ) {
                                         Image(
                                             imageVector = Icons.Default.Search,
                                             contentDescription = "",
                                             modifier = Modifier.background(
                                                 color = Color(0xff6200EE),
                                                 shape = CircleShape
                                             )
                                         )
                                         Spacer(modifier = Modifier.width(10.dp))
                                         Text(text = "Search.....", color = Color.LightGray)
                                     }
                                 }
                                 Spacer(modifier = Modifier.width(10.dp))
                                 Image(
                                     imageVector = Icons.Default.Menu, contentDescription = "",
                                     modifier = Modifier
                                         .border(
                                             width = 1.5.dp,
                                             color = Color(0xff182bff),
                                             shape = RoundedCornerShape(5.5.dp)
                                         )
                                         .padding(5.dp)
                                 )


                             }

                             Spacer(modifier = Modifier.height(20.dp))


                             //Menu 1


                             Row(
                                 horizontalArrangement = Arrangement.SpaceEvenly,
                                 modifier = Modifier
                                     .fillMaxSize()
                                     .horizontalScroll(state = ScrollState(2))

                             ) {

                                 Button(
                                     onClick = {
                                         navController.navigate(ROUTE_ADD_STUDENTS) {
                                             popUpTo(ROUTE_HOME) { inclusive = true }
                                         }
                                     },
                                     shape = RoundedCornerShape(10.dp),
                                     colors = ButtonDefaults.outlinedButtonColors(Color(0xff5bb4fa)),
                                     border = BorderStroke(1.5.dp, Color.Transparent),
                                     contentPadding = PaddingValues(15.dp),
                                     modifier = Modifier
                                         .height(50.dp)
                                         .width(150.dp)
                                 ) {
                                     Text("Web Developer", color = Color.Black)
                                 }

                                 Spacer(modifier = Modifier.width(20.dp))

                                 Button(
                                     onClick = {
                                         navController.navigate(ROUTE_ABOUT) {
                                             popUpTo(ROUTE_HOME) { inclusive = true }
                                         }
                                     },
                                     shape = RoundedCornerShape(10.dp),
                                     colors = ButtonDefaults.outlinedButtonColors(Color(0xff581845)),
                                     border = BorderStroke(1.5.dp, Color.Transparent),
                                     contentPadding = PaddingValues(15.dp),
                                     modifier = Modifier
                                         .height(50.dp)
                                         .width(150.dp)

                                 ) {
                                     Text("Branding Designer", color = Color.Black)
                                 }

                                 Spacer(modifier = Modifier.width(20.dp))


                                 Button(
                                     onClick = {
                                         navController.navigate(ROUTE_ABOUT) {
                                             popUpTo(ROUTE_HOME) { inclusive = true }
                                         }
                                     },
                                     shape = RoundedCornerShape(10.dp),
                                     colors = ButtonDefaults.outlinedButtonColors(Color(0xff3bf975)),
                                     border = BorderStroke(1.5.dp, Color.Transparent),
                                     modifier = Modifier
                                         .height(50.dp)
                                         .width(150.dp)
                                 ) {

                                     Text("Graphic Design", color = Color.Black)
                                 }

                                 Spacer(modifier = Modifier.width(20.dp))

                                 Button(
                                     onClick = {
                                         navController.navigate(ROUTE_ABOUT) {
                                             popUpTo(ROUTE_HOME) { inclusive = true }
                                         }
                                     },
                                     shape = RoundedCornerShape(10.dp),
                                     colors = ButtonDefaults.outlinedButtonColors(Color(0xff16e1a9)),
                                     border = BorderStroke(1.5.dp, Color.Transparent),
                                     modifier = Modifier
                                         .height(50.dp)
                                         .width(150.dp)
                                 ) {
                                     Text("UI/UX", color = Color.Black)
                                 }

                                 Spacer(modifier = Modifier.width(20.dp))


                                 Button(
                                     onClick = {
                                         navController.navigate(ROUTE_ABOUT) {
                                             popUpTo(ROUTE_HOME) { inclusive = true }
                                         }
                                     },
                                     shape = RoundedCornerShape(10.dp),
                                     colors = ButtonDefaults.outlinedButtonColors(Color(0xff121538)),
                                     border = BorderStroke(1.5.dp, Color.Transparent),
                                     modifier = Modifier
                                         .height(50.dp)
                                         .width(150.dp)
                                 ) {
                                     Text("More", color = Color.White)
                                 }

                             }

                             Spacer(modifier = Modifier.height(20.dp))



                             //Text


                             Row(
                                 horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
                                 modifier = Modifier
                                     .fillMaxSize()
                             ) {
                                 Text(text = "Popular in Town", textAlign = TextAlign.Justify)

                                 Text(text = "View all", color = Color.Blue, textAlign = TextAlign.End)
                             }

                             Spacer(modifier = Modifier.height(20.dp))



                             //Menu 2


                             Row(
                                 horizontalArrangement = Arrangement.SpaceEvenly,
                                 modifier = Modifier
                                     .horizontalScroll(state = ScrollState(2))
                                     .fillMaxWidth()
                                     .wrapContentHeight()
                                     .padding(10.dp)
                                     .padding(top = 10.dp)
                             ) {
                                 Column(
                                     modifier = Modifier
                                         .size(width = 350.dp, height = 200.dp)
                                 ) {
                                     Card(onClick = {
                                         navController.navigate(ROUTE_ABOUT) {
                                             popUpTo(ROUTE_HOME) { inclusive = true }
                                         }
                                     }) {
                                         Row(

                                         ) {
                                             Image(
                                                 painter = painterResource(id = R.drawable.kaka),
                                                 contentDescription = "QAQA SOFTWARE",
                                                 modifier = Modifier
                                                     .size(100.dp),
                                             )
                                             Column(
                                                 modifier = Modifier
                                                     .padding(20.dp)
                                             ) {
                                                 Text(text = "Web Designer")
                                                 Text("Qaqa SpecQ")
                                             }

                                         }
                                         Text(
                                             text = AnnotatedString("We are Currently seeking a talented and experienced Web Designer to jion our team.Th..."),
                                             Modifier.padding(5.dp)
                                         )
                                         Row(
                                             modifier = Modifier
                                                 .padding(10.dp)
                                                 .size(width = 300.dp, height = 20.dp),
                                             horizontalArrangement = Arrangement.Absolute.SpaceBetween
                                         ) {
                                             Image(
                                                 imageVector = Icons.Default.LocationOn,
                                                 contentDescription = "" + Text(text = "Kenya")
                                             )

                                             Spacer(modifier = Modifier.width(10.dp))

                                             Image(
                                                 painter = painterResource(id = R.drawable.clock),
                                                 modifier = Modifier.size(20.dp),
                                                 contentDescription = "" + Text(
                                                     text = "FullTime"
                                                 )
                                             )

                                             Spacer(modifier = Modifier.width(10.dp))

                                             Image(
                                                 painter = painterResource(id = R.drawable.suitcase),
                                                 modifier = Modifier.size(20.dp),
                                                 contentDescription = "" + Text(
                                                     text = "1-2 Years"
                                                 )
                                             )
                                         }
                                     }
                                 }

                                 Spacer(modifier = Modifier.width(20.dp))

                                 Column(
                                     modifier = Modifier
                                         .size(width = 350.dp, height = 200.dp)
                                 ) {
                                     Card(onClick = {
                                         navController.navigate(ROUTE_ABOUT) {
                                             popUpTo(ROUTE_HOME) { inclusive = true }
                                         }
                                     }) {
                                         Row(

                                         ) {
                                             Image(
                                                 painter = painterResource(id = R.drawable.kaka),
                                                 contentDescription = "QAQA SOFTWARES",
                                                 modifier = Modifier
                                                     .size(100.dp),
                                             )
                                             Column(
                                                 modifier = Modifier
                                                     .padding(20.dp)
                                             ) {
                                                 Text(text = "Branding Designer")
                                                 Text("Qaqa SpecQ")
                                             }

                                         }
                                         Text(
                                             text = AnnotatedString("We are Currently seeking a talented and experienced Web Designer to jion our team.Th..."),
                                             Modifier.padding(5.dp)
                                         )
                                         Row(
                                             modifier = Modifier
                                                 .padding(10.dp)
                                                 .size(width = 300.dp, height = 20.dp),
                                             horizontalArrangement = Arrangement.Absolute.SpaceBetween
                                         ) {
                                             Image(
                                                 imageVector = Icons.Default.LocationOn,
                                                 contentDescription = "" + Text(text = "Kenya")
                                             )

                                             Spacer(modifier = Modifier.width(10.dp))

                                             Image(
                                                 painter = painterResource(id = R.drawable.clock),
                                                 modifier = Modifier.size(20.dp),
                                                 contentDescription = "" + Text(
                                                     text = "FullTime"
                                                 )
                                             )

                                             Spacer(modifier = Modifier.width(10.dp))

                                             Image(
                                                 painter = painterResource(id = R.drawable.suitcase),
                                                 modifier = Modifier.size(20.dp),
                                                 contentDescription = "" + Text(
                                                     text = "1-2 Years"
                                                 )
                                             )
                                         }
                                     }
                                 }

                                 Spacer(modifier = Modifier.width(20.dp))

                                 Column(
                                     modifier = Modifier
                                         .size(width = 350.dp, height = 200.dp)
                                 ) {
                                     Card(onClick = {
                                         navController.navigate(ROUTE_ABOUT) {
                                             popUpTo(ROUTE_HOME) { inclusive = true }
                                         }
                                     }) {
                                         Row(

                                         ) {
                                             Image(
                                                 painter = painterResource(id = R.drawable.kaka),
                                                 contentDescription = "QAQA SOFTWARES",
                                                 modifier = Modifier
                                                     .size(100.dp),
                                             )
                                             Column(
                                                 modifier = Modifier
                                                     .padding(20.dp)
                                             ) {
                                                 Text(text = "Graphics Designer")
                                                 Text("Qaqa SpecQ")
                                             }

                                         }
                                         Text(
                                             text = AnnotatedString("We are Currently seeking a talented and experienced Web Designer to jion our team.Th..."),
                                             Modifier.padding(5.dp)
                                         )
                                         Row(
                                             modifier = Modifier
                                                 .padding(10.dp)
                                                 .size(width = 300.dp, height = 20.dp),
                                             horizontalArrangement = Arrangement.Absolute.SpaceBetween
                                         ) {
                                             Image(
                                                 imageVector = Icons.Default.LocationOn,
                                                 contentDescription = "" + Text(text = "Kenya")
                                             )

                                             Spacer(modifier = Modifier.width(10.dp))

                                             Image(
                                                 painter = painterResource(id = R.drawable.clock),
                                                 modifier = Modifier.size(20.dp),
                                                 contentDescription = "" + Text(
                                                     text = "FullTime"
                                                 )
                                             )

                                             Spacer(modifier = Modifier.width(10.dp))

                                             Image(
                                                 painter = painterResource(id = R.drawable.suitcase),
                                                 modifier = Modifier.size(20.dp),
                                                 contentDescription = "" + Text(
                                                     text = "1-2 Years"
                                                 )
                                             )
                                         }
                                     }
                                 }

                                 Spacer(modifier = Modifier.width(20.dp))

                                 Column(
                                     modifier = Modifier
                                         .size(width = 350.dp, height = 200.dp)
                                 ) {
                                     Card(onClick = {
                                         navController.navigate(ROUTE_ABOUT) {
                                             popUpTo(ROUTE_HOME) { inclusive = true }
                                         }
                                     }) {
                                         Row(

                                         ) {
                                             Image(
                                                 painter = painterResource(id = R.drawable.kaka),
                                                 contentDescription = "QAQA SOFTWARES",
                                                 modifier = Modifier
                                                     .size(100.dp),
                                             )
                                             Column(
                                                 modifier = Modifier
                                                     .padding(20.dp)
                                             ) {
                                                 Text(text = "UI/UX")
                                                 Text("Qaqa SpecQ")
                                             }

                                         }
                                         Text(
                                             text = AnnotatedString("We are Currently seeking a talented and experienced Web Designer to jion our team.Th..."),
                                             Modifier.padding(5.dp)
                                         )
                                         Row(
                                             modifier = Modifier
                                                 .padding(10.dp)
                                                 .size(width = 300.dp, height = 20.dp),
                                             horizontalArrangement = Arrangement.Absolute.SpaceBetween
                                         ) {
                                             Image(
                                                 imageVector = Icons.Default.LocationOn,
                                                 contentDescription = "" + Text(text = "Kenya")
                                             )

                                             Spacer(modifier = Modifier.width(10.dp))

                                             Image(
                                                 painter = painterResource(id = R.drawable.clock),
                                                 modifier = Modifier.size(20.dp),
                                                 contentDescription = "" + Text(
                                                     text = "FullTime"
                                                 )
                                             )

                                             Spacer(modifier = Modifier.width(10.dp))

                                             Image(
                                                 painter = painterResource(id = R.drawable.suitcase),
                                                 modifier = Modifier.size(20.dp),
                                                 contentDescription = "" + Text(
                                                     text = "1-2 Years"
                                                 )
                                             )
                                         }
                                     }
                                 }

                             }



                             // Testimoniies

                             Column {
                                 Text(text = "Testimonials")
                                 Text(text = "They are just some of those who have trusted our services. We hope your name will be in here to.")
                             }

                             Row(
                                 horizontalArrangement = Arrangement.SpaceEvenly,
                                 modifier = Modifier
                                     .horizontalScroll(state = ScrollState(2))
                                     .fillMaxWidth()
                                     .wrapContentHeight()
                                     .padding(10.dp)
                                     .padding(top = 10.dp)
                             ) {
                                 Column(
                                     modifier = Modifier
                                         .size(width = 350.dp, height = 140.dp)
                                 ) {
                                     Card(
                                         modifier = Modifier
                                             .fillMaxWidth()
                                             .padding(top = 6.dp)
                                             .wrapContentHeight(align = Alignment.CenterVertically),
                                         elevation = CardDefaults.cardElevation(8.dp),
                                         shape = CutCornerShape(topEnd = 20.dp)
                                     ) {
                                         Box(modifier = Modifier
                                             .fillMaxSize()
                                             .background(color = Color(0xffaee2e1)))
                                         {
//                                             Image(
//                                                 painter = painterResource(id = R.drawable.kaka),
//                                                 contentDescription = "QAQA SOFTWARE",
//                                                 modifier = Modifier
//                                                     .size(100.dp)
//                                             )
                                             Row {
                                                 Image(
                                                     painter = painterResource(id = R.drawable.kaka),
                                                     contentDescription = "QAQA SOFTWARE",
                                                     modifier = Modifier
                                                         .size(100.dp),
                                                 )
                                                 Column(
                                                     modifier = Modifier
                                                         .padding(20.dp)
                                                 ) {
                                                     Text(text = "Qaqa SpecQ")
                                                     Text("Founder -Qaqa Softwares")
                                                     Spacer(modifier = Modifier.height(20.dp))
                                                     Text(
                                                         text = AnnotatedString("Great communication through out the project development."),

                                                     )
                                                 }

                                             }

                                         }
                                     }
                                 }

                                 Spacer(modifier = Modifier.width(20.dp))

                                 Column(
                                     modifier = Modifier
                                         .size(width = 350.dp, height = 140.dp)
                                 ) {
                                     Card(
                                         modifier = Modifier
                                             .fillMaxWidth()
                                             .padding(top = 6.dp)
                                             .wrapContentHeight(align = Alignment.CenterVertically),
                                         shape = CutCornerShape(topEnd = 20.dp),
                                         elevation = CardDefaults.cardElevation(8.dp)
                                     ) {
                                         Box(modifier = Modifier
                                             .fillMaxSize()
                                             .background(color = Color(0xffaee2e1)))
                                         {
//                                             Image(
//                                                 painter = painterResource(id = R.drawable.kaka),
//                                                 contentDescription = "QAQA SOFTWARE",
//                                                 modifier = Modifier
//                                                     .size(100.dp),
//                                                 Alignment.TopEnd
//                                             )
                                             Row {
                                                 Image(
                                                     painter = painterResource(id = R.drawable.kaka),
                                                     contentDescription = "QAQA SOFTWARE",
                                                     modifier = Modifier
                                                         .size(100.dp),
                                                 )
                                                 Column(
                                                     modifier = Modifier
                                                         .padding(20.dp)
                                                 ) {
                                                     Text(text = "Qaqa SpecQ")
                                                     Text("Founder -Qaqa Softwares")
                                                     Spacer(modifier = Modifier.height(20.dp))
                                                     Text(
                                                         text = AnnotatedString("Great communication through out the project development."),

                                                         )
                                                 }

                                             }

                                         }
                                     }
                                 }
                                 Spacer(modifier = Modifier.width(20.dp))

                                 Column(
                                     modifier = Modifier
                                         .size(width = 350.dp, height = 140.dp)
                                 ) {
                                     Card(
                                         modifier = Modifier
                                             .fillMaxWidth()
                                             .padding(top = 6.dp)
                                             .wrapContentHeight(align = Alignment.CenterVertically),
                                         shape = CutCornerShape(topEnd = 20.dp),
                                         elevation = CardDefaults.cardElevation(8.dp)
                                     ) {
                                         Box(modifier = Modifier
                                             .fillMaxSize()
                                             .background(color = Color(0xffaee2e1)))
                                         {
//                                             Image(
//                                                 painter = painterResource(id = R.drawable.kaka),
//                                                 contentDescription = "QAQA SOFTWARE",
//                                                 modifier = Modifier
//                                                     .size(100.dp),
//                                                 Alignment.TopEnd
//                                             )
                                             Row {
                                                 Image(
                                                     painter = painterResource(id = R.drawable.kaka),
                                                     contentDescription = "QAQA SOFTWARE",
                                                     modifier = Modifier
                                                         .size(100.dp),
                                                 )
                                                 Column(
                                                     modifier = Modifier
                                                         .padding(20.dp)
                                                 ) {
                                                     Text(text = "Qaqa SpecQ")
                                                     Text("Founder -Qaqa Softwares")
                                                     Spacer(modifier = Modifier.height(20.dp))
                                                     Text(
                                                         text = AnnotatedString("Great communication through out the project development."),

                                                         )
                                                 }

                                             }

                                         }
                                     }
                                 }
                             }
                         }
             }
         },

         bottomBar = {BottomBar(navController)}
     )

 }


 @Composable
 fun BottomBar(navController: NavHostController) {
     val selectedIndex = remember { mutableStateOf(0) }
     BottomNavigation(elevation = 10.dp) {
         BottomNavigationItem(icon = {
             Icon(imageVector = Icons.Default.Home,"")
         },
             label = { Text(text = "Home") }, selected = (selectedIndex.value == 0), onClick = {
                 navController.navigate(ROUTE_HOME) {
                     popUpTo(ROUTE_HOME) { inclusive = true }
                 }
             })
         BottomNavigationItem(icon = {
             Icon(imageVector = Icons.Default.Refresh,"")
         },
             label = { Text(text = "JobInn") }, selected = (selectedIndex.value == 1), onClick = {
                 navController.navigate(ROUTE_ADD_STUDENTS) {
                 popUpTo(ROUTE_HOME) { inclusive = true }
             }
             })
         BottomNavigationItem(icon = {
             Icon(imageVector = Icons.Default.AccountCircle, "")
         },
             label = { Text(text = "Profile") }, selected = (selectedIndex.value == 2), onClick = {
                 navController.navigate(ROUTE_CONTACT) {
                     popUpTo(ROUTE_HOME) { inclusive = true }
                 }
             })
     }
 }


@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    HomeScreen(rememberNavController())
}

