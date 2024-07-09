@file:Suppress("PreviewAnnotationInFunctionWithParameters")


package net.ezra.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_ADD_PRODUCT
import net.ezra.navigation.ROUTE_HOME

data class Screen(val title: String, val icon: Int)

@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ResourceAsColor")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun HomeScreen(navController: NavHostController) {
    val context = LocalContext.current
    var isDrawerOpen by remember { mutableStateOf(false) }
    val imageList = listOf(R.drawable.hurry, R.drawable.flood, R.drawable.house)
    var currentIndex by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000) // Change image every 3 seconds
            currentIndex = (currentIndex + 1) % imageList.size
        }
    }

    Scaffold(
        topBar = { HomeTopBar(isDrawerOpen, { isDrawerOpen = it }) },
        content = {
            HomeContent(navController, imageList[currentIndex], isDrawerOpen) { isDrawerOpen = false }
        },
        bottomBar = { BottomBar(navController) }
    )

    AnimatedDrawer(
        isOpen = isDrawerOpen,
        onClose = { isDrawerOpen = false }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(isDrawerOpen: Boolean, onDrawerToggle: (Boolean) -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(44.dp)
                        .clickable { /* Handle image click */ },
                    painter = painterResource(id = R.drawable.no),
                    contentDescription = "image"
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "Risk Management", color = Color.White)
                Spacer(modifier = Modifier.weight(1f))
            }
        },
        actions = {
            if (!isDrawerOpen) {
                IconButton(onClick = { onDrawerToggle(true) }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu",
                        tint = Color.White
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White,
        )
    )
}

@Composable
fun HomeContent(navController: NavHostController, currentImageResId: Int, isDrawerOpen: Boolean, onContentClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                if (isDrawerOpen) {
                    onContentClick()
                }
            }
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = currentImageResId),
            contentDescription = "Carousel Image"
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {

            item {
                Spacer(modifier = Modifier
                    .height(50.dp))
                Card(
                    colors = CardDefaults.cardColors(Color.LightGray),
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(10.dp),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "What is disaster management?",
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black,
                            fontSize = 25.sp,
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "Disaster management is a critical and multifaceted field that encompasses the preparation, " +
                                    "response, recovery, and mitigation of natural and man-made disasters. Its primary goal is " +
                                    "to minimize the adverse effects of disasters on human lives, property, and the environment."
                        )
                    }
                }
            }
            // Add more items to the LazyColumn if needed
        }
    }
}

@Composable
fun AnimatedDrawer(isOpen: Boolean, onClose: () -> Unit) {
    val drawerWidth = remember { Animatable(if (isOpen) 250f else 0f) }
    val callLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) {}

    LaunchedEffect(isOpen) {
        drawerWidth.animateTo(if (isOpen) 250f else 0f, animationSpec = tween(durationMillis = 300))
    }

    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .width(drawerWidth.value.dp),
        color = Color.DarkGray
    ) {
        Column {
            Text(
                modifier = Modifier,
                color = Color.Red,
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                text = "Contact:"
            )
            ContactItem("i) UNDRR", "+254 20 762 6719", callLauncher)
            ContactItem("ii) NDOC", "+254 20 221 2386", callLauncher)
            ContactItem("iii) UNEP", "+254 20 762 1234", callLauncher)
            ContactItem("iv) RED CROSS", "020 3950000", callLauncher)
            ContactItem("v) THE POLICE", "999", callLauncher)
        }
    }
}

@Composable
fun ContactItem(label: String, phoneNumber: String, callLauncher: ManagedActivityResultLauncher<Intent, ActivityResult>) {
    Text(
        modifier = Modifier
            .padding(20.dp)
            .clickable {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:$phoneNumber")
                }
                callLauncher.launch(intent)
            },
        color = Color.Cyan,
        text = label
    )
}

@Composable
fun BottomBar(navController: NavHostController) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        elevation = 10.dp,
        backgroundColor = Color.Black
    ) {
        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Default.Info, "", tint = Color.White) },
            label = { Text(text = "More info", color = Color.White) },
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
                navController.navigate(ROUTE_ABOUT) {
                    popUpTo(ROUTE_HOME) { inclusive = true }
                }
            }
        )
        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Default.Warning, "", tint = Color.White) },
            label = { Text(text = "Talk to us", color = Color.White) },
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
                navController.navigate(ROUTE_ADD_PRODUCT) {
                    popUpTo(ROUTE_HOME) { inclusive = true }
                }
            }
        )
    }
}

//            Button(
//                modifier = Modifier,
//                colors = ButtonDefaults.buttonColors(Color.Black),
//                onClick = {
//                    navController.navigate(ROUTE_DASHBOARD) {
//                 popUpTo(ROUTE_HOME) { inclusive = true }
//                    }
//                }
//            ) {
//                Text(
//                    modifier = Modifier.fillMaxWidth(),
//                    color = Color.Red,
//                    textAlign = TextAlign.Center,
//                    text = "Continue.."
//                )

//package net.ezra.ui.home
//
//
//
//
//
//
//import android.annotation.SuppressLint
//import android.content.Intent
//import android.net.Uri
//import android.os.Build
//import androidx.activity.compose.rememberLauncherForActivityResult
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.annotation.RequiresApi
//import androidx.compose.animation.core.Animatable
//import androidx.compose.animation.core.tween
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.BottomNavigation
//import androidx.compose.material.BottomNavigationItem
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Info
//import androidx.compose.material.icons.filled.Menu
//import androidx.compose.material.icons.filled.Warning
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.CenterAlignedTopAppBar
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import net.ezra.R
//import net.ezra.navigation.ROUTE_ABOUT
//import net.ezra.navigation.ROUTE_ADD_PRODUCT
//import net.ezra.navigation.ROUTE_DASHBOARD
//import net.ezra.navigation.ROUTE_HOME
//data class Screen(val title: String, val icon: Int)
//@RequiresApi(Build.VERSION_CODES.Q)
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ResourceAsColor")
//@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
//@Composable
//fun HomeScreen(navController: NavHostController) {
//    val Greet= LocalContext.current
//    var isDrawerOpen by remember { mutableStateOf(false) }
//
//
//    Scaffold(
//        topBar = {
//            CenterAlignedTopAppBar(
//                title = {
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.Start,
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Image(
//                            modifier = Modifier
//                                .size(44.dp)
//                                .clickable { /* Handle image click */ },
//                            painter = painterResource(id = R.drawable.no),
//                            contentDescription = "image"
//                        )
//                        Spacer(modifier = Modifier.weight(1f))
//                        Text(text = "Risk Management", color = Color.White)
//                        Spacer(modifier = Modifier.weight(1f))
//                    }
//                },
//                actions = {
//                    if (!isDrawerOpen) {
//                        IconButton(onClick = { isDrawerOpen = true }) {
//                            Icon(
//                                imageVector = Icons.Default.Menu,
//                                contentDescription = "Menu",
//                                tint = Color.White
//                            )
//                        }
//                    }
//                },
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color.Black,
//                    titleContentColor = Color.White,
//                )
//            )
//        },
//
//        content = @Composable {
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .clickable {
//                        if (isDrawerOpen) {
//                            isDrawerOpen = false
//                        }
//                    }
//            ) {
//                Image(
//                    modifier = Modifier
//                        .fillMaxSize(),
//                    contentScale = ContentScale.Fit
//
//                    ,
//
//                    painter = painterResource(id = R.drawable.earth), contentDescription = "image")
//
//
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize(),
//
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                Text(text = "What is disaster management?",
//                modifier=Modifier,
//                    fontWeight = FontWeight.ExtraBold,
//                    color = Color.Black,
//                    fontSize = 25.sp,
//
//                )
//                   Spacer(modifier = Modifier.height(15.dp))
//
//                  Text(text =
//                          "Disaster management is a critical and multifaceted" +
//                          " field that encompasses the preparation, " +
//                          "response, recovery, and mitigation of natural " +
//                          "and man-made disasters. Its primary goal is " +
//                          "to minimize the adverse effects of disasters " +
//                          "on human lives, property, and the environment." +
//                          " Effective disaster management requires a " +
//                          "coordinated effort among various stakeholders," +
//                          " including government agencies, non-governmental" +
//                          " organizations, and the community. By understanding" +
//                          " the dynamics of disasters and implementing strategic " +
//                          "planning, we can enhance our resilience and ensure" +
//                          " a more rapid and efficient recovery. This " +
//                          "presentation will delve into the essential " +
//                          "components of disaster management, highlighting " +
//                          "best practices, case studies, and innovative approaches" +
//                                  " to creating a safer and more prepared society.")
//                    Spacer(modifier = Modifier.height(25.dp))
//
//
//                    Button(
//                        modifier = Modifier,
//                        colors = ButtonDefaults.buttonColors(Color.Black),
//                        onClick = {
//                        navController.navigate(ROUTE_DASHBOARD ) {
//                            popUpTo(ROUTE_HOME) { inclusive = true }
//                        }}
//                                        ) {
//
//                        Text(
//                            modifier = Modifier
//                                .fillMaxWidth(),
//                            color = Color.Red,
//                            textAlign = TextAlign.Center,
//
//
//
//                            text = "Continue..")
//
//                    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//                }
//
//            }
//
//        },
//
//        bottomBar = { BottomBar(navController = navController) }
//
//
//
//
//
//
//
//    )
//
//    AnimatedDrawer(
//        isOpen = isDrawerOpen,
//        onClose = { isDrawerOpen = false }
//    )
//}
//
//@Composable
//fun AnimatedDrawer(isOpen: Boolean, onClose: () -> Unit) {
//    val drawerWidth = remember { Animatable(if (isOpen) 250f else 0f) }
//    val callLauncher = rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.StartActivityForResult()
//    ) {}
//
//    LaunchedEffect(isOpen) {
//        drawerWidth.animateTo(if (isOpen) 250f else 0f, animationSpec = tween(durationMillis = 300))
//    }
//
//    Surface(
//        modifier = Modifier
//            .fillMaxHeight()
//            .width(drawerWidth.value.dp),
//        color = Color.DarkGray,
////       elevation = 16.dp
//    )
//
//
//    {
//        Column {
//            Text(
//                modifier = Modifier,
//                 color = Color.Red,
//                fontSize = 25.sp,
//                textAlign = TextAlign.Center,
//
//                text = "Contact:")
//            Text(
//                modifier = Modifier
//                    .padding(20.dp)
//                    .clickable {
//                        val intent = Intent(Intent.ACTION_DIAL)
//                        intent.data = Uri.parse("tel:+254 20 762 6719")
//                        callLauncher.launch(intent)
//                    },
//                color = Color.Cyan,
//                text = "i) UNDRR"
//            )
//
//
//            Text(
//                modifier = Modifier
//                    .padding(20.dp)
//                    .clickable {
//                        val intent = Intent(Intent.ACTION_DIAL)
//                        intent.data = Uri.parse("tel:+254 20 221 2386 ")
//                        callLauncher.launch(intent)
//                    },
//                color = Color.Cyan,
//                text = "ii) NDOC"
//            )
//            Text(
//                modifier = Modifier
//                    .padding(20.dp)
//                    .clickable {
//                        val intent = Intent(Intent.ACTION_DIAL)
//                        intent.data = Uri.parse("tel:+254 20 762 1234")
//                        callLauncher.launch(intent)
//                    },
//                color = Color.Cyan,
//                text = "iii) UNEP",
//
//                )
//            Text(
//                modifier = Modifier
//                    .padding(20.dp)
//                    .clickable {
//                        val intent = Intent(Intent.ACTION_DIAL)
//                        intent.data = Uri.parse("tel:020 3950000")
//                        callLauncher.launch(intent)
//                    },
//                color = Color.Cyan,
//                text = "iv) RED CROSS"
//            )
//
//            Text(
//                modifier = Modifier
//                    .padding(20.dp)
//                    .clickable {
//                        val intent = Intent(Intent.ACTION_DIAL)
//                        intent.data = Uri.parse("tel:999")
//                        callLauncher.launch(intent)
//                    },
//                color = Color.Cyan,
//                text = "v)THE POLICE"
//            )
//        }
//    }
//}
//
//
//
//
//
//
//@Composable
//fun BottomBar(navController: NavHostController) {
//    val selectedIndex = remember { mutableStateOf(0) }
//    BottomNavigation(
//        elevation = 10.dp,
//        backgroundColor = Color.Black
//
//
//    ) {
//
//
//
//        BottomNavigationItem(icon = {
//            Icon(imageVector = Icons.Default.Info,"",tint = Color.White)
//        },
//            label = { Text(text = "More info",color =  Color.White) },
//            selected = (selectedIndex.value == 1), onClick = {
//                navController.navigate(ROUTE_ABOUT) {
//                    popUpTo(ROUTE_HOME) { inclusive = true }
//                }
//            })
//
//        BottomNavigationItem(icon = {
//            Icon(imageVector = Icons.Default.Warning, "",tint = Color.White)
//        },
//            label = { Text(
//                text = "Talk to us",
//                color =  Color.White) },
//            selected = (selectedIndex.value == 2),
//            onClick = {
//                        navController.navigate(ROUTE_ADD_PRODUCT) {
//                            popUpTo(ROUTE_HOME) { inclusive = true }
//                        }}
//        )
//
//    }
//
//}