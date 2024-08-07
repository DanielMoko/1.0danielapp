@file:Suppress("PreviewAnnotationInFunctionWithParameters")

package net.ezra.ui.about

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import net.ezra.R
import net.ezra.navigation.ROUTE_HOME


@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ResourceAsColor")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AboutScreen(navController: NavHostController) {
    val context = LocalContext.current
//    Scaffold(
//        topBar = {
//            CenterAlignedTopAppBar(
//                title = {
//                    Row {
//                        IconButton(onClick = {  }) {
//                            Image(
//                                imageVector = ImageVector.vectorResource(id = R.drawable.no),
//                                contentDescription = "Icon",
//                                modifier = Modifier.size(10.dp)
//                            )
//                        }
//                        Text("Organisations Involved")
//                    }
//                },
//                // If you need to add elevation, uncomment the next line
//                // elevation = 4.dp,
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color.DarkGray,
//                    titleContentColor = Color.White,
//                )
//            )
//        }
//    )
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Organisations Involved") },
                // If you need to add elevation, uncomment the next line
                // elevation = 4.dp,
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = DarkGray,
                    titleContentColor = Color.White,
                ),
                navigationIcon = {
                    IconButton(onClick = {  navController.navigate(ROUTE_HOME)}) {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "home",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    )

//            Icon = @Composable {
//
//                    IconButton(onClick = { }) {
//                        Icon(
//                            Icons.Default.Menu,
//                            contentDescription = "Menu",
//                            tint = Color.White
//                        )
//                    }
//
//            }




    {
//        Column(
//            modifier = Modifier.padding(16.dp)
//        ) {
//            // Your content here
//            Card(
//                shape = RoundedCornerShape(8.dp),
//               // elevation = 4.dp,
//                colors = CardDefaults.cardColors(Color.Red),
//                modifier = Modifier
//
//                    .height(200.dp)
//                    .padding(top = 8.dp) // Adjust top padding to prevent overlap
//            ) {
//                Text(text = "Card content")
//            }
//        }
//    }
        Image(
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop,

            painter = painterResource(id = R.drawable.stream),
            contentDescription = "image"
        )
        LazyColumn {
            item {
                Spacer(modifier = Modifier
                    .height(70.dp))
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    // horizontalAlignment = Alignment.CenterHorizontally,
                )
                {
                    Card(
                        colors = CardDefaults.cardColors(Color.Unspecified),
                        shape = RoundedCornerShape(20.dp),

                        elevation = CardDefaults.cardElevation(10.dp),
                        modifier = Modifier
                            .height(290.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(8.dp)
                                .clickable {
                                    val url = "https://www.redcross.or.ke/"
                                    val intent = Intent(Intent.ACTION_VIEW)
                                    intent.data = Uri.parse(url)
                                    context.startActivity(intent)
                                }
                        )

                        {







                            Image(
//                  modifier = Modifier
//                      .fillMaxSize(),
                                // contentScale = ContentScale.Fit

                                // ,

                                painter = painterResource(id = R.drawable.redcross),
                                contentDescription = "image"
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            Text(
                                text = "Kenya Red Cross Society (KRCS)" +
                                        " is the leading humanitarian organization in Kenya." +
                                        " It focuses on disaster response, health and social services," +
                                        " and promoting humanitarian values. The organization provides" +
                                        " emergency relief during disasters, offers first aid training," +
                                        " and engages in community-based disaster preparedness."
                            )
                            Button(

                                onClick = {
                                    val url = "https://www.redcross.or.ke/"
                                    val intent = Intent(Intent.ACTION_VIEW)
                                    intent.data = Uri.parse(url)
                                    context.startActivity(intent)
                                },
                                colors = ButtonDefaults.buttonColors(Red)
                            ) {

                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,



                                    text = "Access our website")

                            }
                        }
                    }
                }
                Spacer(modifier = Modifier
                    .height(20.dp)
                )

                Card(
                    colors = CardDefaults.cardColors(Color.Unspecified),
                    shape = RoundedCornerShape(20.dp),

                    elevation = CardDefaults.cardElevation(10.dp),
                    modifier = Modifier
                        .height(300.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                val url =
                                    "https://www.un-spider.org/kenya-national-disaster-operations-centre-ndoc"
                                val intent = Intent(Intent.ACTION_VIEW)
                                intent.data = Uri.parse(url)
                                context.startActivity(intent)
                            },
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(


                            painter = painterResource(id = R.drawable.name),
                            contentDescription = "image"
                        )

                        Spacer(
                            modifier = Modifier
                                .height(20.dp)
                        )
                        Text(
                            text = "National Disaster Operations Centre (NDOC) is a government" +
                                    " agency under the Ministry of Interior and Coordination of " +
                                    "National Government. It coordinates disaster response and " +
                                    "management efforts across the country, ensuring a unified " +
                                    "approach to disaster management and resource allocation."
                        )
                        Button(

                            onClick = {
                                val url =
                                    "https://www.un-spider.org/kenya-national-disaster-operations-centre-ndoc"
                                val intent = Intent(Intent.ACTION_VIEW)
                                intent.data = Uri.parse(url)
                                context.startActivity(intent)
                            },
                            colors = ButtonDefaults.buttonColors(Red)
                        ) {

                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                color = Color.Black,
                                textAlign = TextAlign.Center,



                                text = "Access our website")

                        }
                    }
                }
                Spacer(modifier = Modifier
                    .height(20.dp)
                )

                Card(
                    colors = CardDefaults.cardColors(Color.Unspecified),
                    shape = RoundedCornerShape(20.dp),

                    elevation = CardDefaults.cardElevation(10.dp),
                    modifier = Modifier
                        .height(290.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                val url = "https://www.undrr.org/"
                                val intent = Intent(Intent.ACTION_VIEW)
                                intent.data = Uri.parse(url)
                                context.startActivity(intent)
                            },
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(


                            painter = painterResource(id = R.drawable.mariya),
                            contentDescription = "mariya"
                        )

                        Spacer(
                            modifier = Modifier
                                .height(20.dp)
                        )
                        Text(
                            text = "United Nations Office for Disaster Risk Reduction (UNDRR)" +
                                    " works globally to support countries in disaster risk " +
                                    "reduction efforts, promoting resilience and sustainable " +
                                    "development to reduce the impact of disasters."
                        )

                        Button(

                            onClick = {
                                val url = "https://www.undrr.org/"
                                val intent = Intent(Intent.ACTION_VIEW)
                                intent.data = Uri.parse(url)
                                context.startActivity(intent)
                            },
                            colors = ButtonDefaults.buttonColors(Red)
                        ) {

                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                color = Color.Black,
                                textAlign = TextAlign.Center,



                                text = "Access our website")

                        }
                    }
                }
                Spacer(modifier = Modifier
                    .height(20.dp)
                )
                Card(
                    colors = CardDefaults.cardColors(Color.Unspecified),
                    shape = RoundedCornerShape(20.dp),

                    elevation = CardDefaults.cardElevation(10.dp),
                    modifier = Modifier
                        .height(290.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                val url = "https://www.unep.org/"
                                val intent = Intent(Intent.ACTION_VIEW)
                                intent.data = Uri.parse(url)
                                context.startActivity(intent)
                            },
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(


                            painter = painterResource(id = R.drawable.photo),
                            contentDescription = "mariya"
                        )

                        Spacer(
                            modifier = Modifier
                                .height(20.dp)
                        )
                        Text(
                            text = "United Nations Environment Programme (UNEP)" +
                                    " is a UN agency addressing environmental issues " +
                                    "globally, including disaster risk reduction through" +
                                    " sustainable environmental management and policy support."
                        )
                        Button(

                            onClick = {
                                val url = "https://www.unep.org/"
                                val intent = Intent(Intent.ACTION_VIEW)
                                intent.data = Uri.parse(url)
                                context.startActivity(intent)
                            },
                            colors = ButtonDefaults.buttonColors(Red)
                        ) {

                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                color = Color.Black,
                                textAlign = TextAlign.Center,



                                text = "Access our website")

                        }
                    }}
                Spacer(modifier = Modifier
                    .height(20.dp)
                )

                Card(
                    colors = CardDefaults.cardColors(Color.Unspecified),
                    shape = RoundedCornerShape(20.dp),

                    elevation = CardDefaults.cardElevation(10.dp),
                    modifier = Modifier
                        .height(240.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                val url = "https://meteo.go.ke/"
                                val intent = Intent(Intent.ACTION_VIEW)
                                intent.data = Uri.parse(url)
                                context.startActivity(intent)
                            } ,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(


                            painter = painterResource(id = R.drawable.put),
                            contentDescription = "mariya"
                        )

                        Spacer(
                            modifier = Modifier
                                .height(20.dp)
                        )
                        Text(
                            text = "Kenya Meteorological Department (KMD) provides " +
                                    "weather and climate information services," +
                                    " including forecasts and warnings, to enhance " +
                                    "preparedness and response to weather-related disasters."
                        )
                        Button(

                            onClick = {
                                val url = "https://meteo.go.ke/"
                                val intent = Intent(Intent.ACTION_VIEW)
                                intent.data = Uri.parse(url)
                                context.startActivity(intent)
                            },
                            colors = ButtonDefaults.buttonColors(Red)
                        ) {

                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                color = Color.Black,
                                textAlign = TextAlign.Center,



                                text = "Access our website")

                        }
                    }}
                Spacer(modifier = Modifier
                    .height(20.dp)
                )
                Card(
                    colors = CardDefaults.cardColors(Color.Unspecified),
                    shape = RoundedCornerShape(20.dp),

                    elevation = CardDefaults.cardElevation(10.dp),
                    modifier = Modifier
                        .height(280.dp)
                ) {
                    Column(
                        modifier = Modifier
                            //.fillMaxSize()
                            .clickable {
                                val url = "https://ndma.go.ke/"
                                val intent = Intent(Intent.ACTION_VIEW)
                                intent.data = Uri.parse(url)
                                context.startActivity(intent)
                            } ,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(


                            painter = painterResource(id = R.drawable.ok),
                            contentDescription = "mariya"
                        )

                        Spacer(
                            modifier = Modifier
                                .height(20.dp)
                        )
                        Spacer(modifier = Modifier
                            .height(20.dp)
                        )
                        Text(
                            text = "National Drought Management Authority (NDMA) is a " +
                                    "Government agency tasked with coordinating drought" +
                                    " management efforts, including early warning systems" +
                                    " and mitigation strategies."
                        )
                        Button(

                            onClick = { val url = "https://ndma.go.ke/"
                                val intent = Intent(Intent.ACTION_VIEW)
                                intent.data = Uri.parse(url)
                                context.startActivity(intent)
                            },
                            colors = ButtonDefaults.buttonColors(Red)
                        ) {

                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                color = Color.Black,
                                textAlign = TextAlign.Center,



                                text = "Access our website")

                        }
                    }}









            }
        }
    }
}
//
//    Column {
//        Text(text = "about")
//
//        Text(text = stringResource(id = R.string.apen))
//
//        Text(
//            modifier = Modifier
//
//                .clickable {
//                    navController.navigate(ROUTE_HOME) {
//                        popUpTo(ROUTE_ABOUT) { inclusive = true }
//                    }
//                },
//            text = "Home",
//            textAlign = TextAlign.Center,
//            color = MaterialTheme.colorScheme.onSurface
//        )
//    }



//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
//@Composable
//fun HomeScreenPreviewLight() {
//    AboutScreen(rememberNavController())
//}