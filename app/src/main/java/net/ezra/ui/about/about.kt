@file:Suppress("PreviewAnnotationInFunctionWithParameters")

package net.ezra.ui.about

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_HOME
import net.ezra.ui.dashboard.DashboardItem
import net.ezra.ui.dashboard.DashboardItemData


@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ResourceAsColor")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AboutScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("More Information") },
                //elevation = 4.dp
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = DarkGray,
                    titleContentColor = Color.White,
                )
            )}
//        ,
//                colors = TopAppBarDefaults.topAppBarColors(
//                containerColor = Color.DarkGray,
//        titleContentColor = Color.White,

        )

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
//                        .clickable {
//                            val url = "https://www.redcross.or.ke/"
//                            val intent = Intent(Intent.ACTION_VIEW)
//                            intent.data = Uri.parse(url)
//                            context.startActivity(intent)
//                        }
//                        .padding(top = 8.dp) // Adjust top padding to prevent overlap
//                ) {
//                    Text(text = "Click me to visit Red Cross Kenya")
//                }



                ) {
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

                }
            }

            Card(
                colors = CardDefaults.cardColors(Color.Unspecified),
                shape = RoundedCornerShape(20.dp),

                elevation = CardDefaults.cardElevation(10.dp),
                modifier = Modifier
                    .height(280.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
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
                }
            }

            Card(
                colors = CardDefaults.cardColors(Color.Unspecified),
                shape = RoundedCornerShape(20.dp),

                elevation = CardDefaults.cardElevation(10.dp),
                modifier = Modifier
                    .height(260.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
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


                }
            }
            Card(
                colors = CardDefaults.cardColors(Color.Unspecified),
                shape = RoundedCornerShape(20.dp),

                elevation = CardDefaults.cardElevation(10.dp),
                modifier = Modifier
                    .height(250.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
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
                }}

            Card(
                colors = CardDefaults.cardColors(Color.Unspecified),
                shape = RoundedCornerShape(20.dp),

                elevation = CardDefaults.cardElevation(10.dp),
                modifier = Modifier
                    .height(240.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
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
                }}

            Card(
                colors = CardDefaults.cardColors(Color.Unspecified),
                shape = RoundedCornerShape(20.dp),

                elevation = CardDefaults.cardElevation(10.dp),
                modifier = Modifier
                    .height(250.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
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
                }}









                }
    }
}
}}
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

