@file:Suppress("PreviewAnnotationInFunctionWithParameters")

package net.ezra.ui.home






import android.annotation.SuppressLint
import android.content.ClipData.Item
import android.content.Intent
import android.icu.text.CaseMap.Title
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
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_ADD_PRODUCT
import net.ezra.navigation.ROUTE_ADD_STUDENTS
import net.ezra.navigation.ROUTE_DASHBOARD
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_SEARCH
import net.ezra.navigation.ROUTE_VIEW_PROD
import net.ezra.navigation.ROUTE_VIEW_STUDENTS
import net.ezra.ui.students.BottomBar


data class Screen(val title: String, val icon: Int)
@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ResourceAsColor")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun HomeScreen(navController: NavHostController) {
    val Greet= LocalContext.current
    var isDrawerOpen by remember { mutableStateOf(false) }


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Risk Management")
                },
                navigationIcon = @Composable {
                    if (!isDrawerOpen) {
                        IconButton(onClick = { isDrawerOpen = true }) {
                            Icon(
                                Icons.Default.Menu,
                                contentDescription = "Menu",
                                tint = Color.White
                                )
                        }
                    }
                },

//                actions = {
//                    IconButton(onClick = {
//                        navController.navigate(ROUTE_LOGIN) {
//                            popUpTo(ROUTE_HOME) { inclusive = true }
//                        }
//
//                    }) {
//                        Icon(
//                            imageVector = Icons.Filled.AccountCircle,
//                            contentDescription = null,
//                            tint = Color.White
//                        )
//                    }
//                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.DarkGray,
                    titleContentColor = Color.White,

                )

            )
        },

        content = @Composable {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        if (isDrawerOpen) {
                            isDrawerOpen = false
                        }
                    }
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Fit

                    ,

                    painter = painterResource(id = R.drawable.earth), contentDescription = "image")


                Column(
                    modifier = Modifier
                        .fillMaxSize(),

                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                Text(text = "What is disaster management?", 
                modifier=Modifier,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Black,
                    fontSize = 25.sp,
                    
                )
                   Spacer(modifier = Modifier.height(15.dp))
                    
                  Text(text =
                          "Disaster management is a critical and multifaceted" +
                          " field that encompasses the preparation, " +
                          "response, recovery, and mitigation of natural " +
                          "and man-made disasters. Its primary goal is " +
                          "to minimize the adverse effects of disasters " +
                          "on human lives, property, and the environment." +
                          " Effective disaster management requires a " +
                          "coordinated effort among various stakeholders," +
                          " including government agencies, non-governmental" +
                          " organizations, and the community. By understanding" +
                          " the dynamics of disasters and implementing strategic " +
                          "planning, we can enhance our resilience and ensure" +
                          " a more rapid and efficient recovery. This " +
                          "presentation will delve into the essential " +
                          "components of disaster management, highlighting " +
                          "best practices, case studies, and innovative approaches" +
                                  " to creating a safer and more prepared society.")
                    Spacer(modifier = Modifier.height(25.dp))


                    Button(
                        modifier = Modifier,
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        onClick = {
                        navController.navigate(ROUTE_ADD_PRODUCT) {
                            popUpTo(ROUTE_HOME) { inclusive = true }
                        }}) {

                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            color = Color.Red,
                            textAlign = TextAlign.Center,

                            

                            text = "Continue..")

                    }
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    

//
//                    Text(
//                        text = stringResource(id = R.string.developer),
//                        fontSize = 20.sp,
//                    )
//
//                    Spacer(modifier = Modifier.height(15.dp))
//
//                    Text(
//                        modifier = Modifier
//
//                            .clickable {
//                                navController.navigate(ROUTE_LOGIN) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            },
//                        text = "Login Here",
//                        textAlign = TextAlign.Center,
//                        fontSize = 20.sp,
//                        color = MaterialTheme.colorScheme.onSurface
//                    )
//
//
////
//                    Text(
//                        modifier = Modifier
//
//                            .clickable {
//                                navController.navigate(ROUTE_ADD_PRODUCT) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            },
//                        text = "Add Products",
//                        textAlign = TextAlign.Center,
//                        fontSize = 20.sp,
//                        color = MaterialTheme.colorScheme.onSurface
//                    )
//
//                    Text(
//                        modifier = Modifier
//
//                            .clickable {
//                                navController.navigate(ROUTE_ADD_STUDENTS) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            },
//                        text = "Add Students",
//                        textAlign = TextAlign.Center,
//                        fontSize = 20.sp,
//                        color = MaterialTheme.colorScheme.onSurface
//                    )
//
                    Text(
                        modifier = Modifier

                            .clickable {
                                navController.navigate(ROUTE_VIEW_PROD) {
                                    popUpTo(ROUTE_HOME) { inclusive = true }
                                }
                            },
                        text = "view Products",
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
//
//
//
//                    Spacer(modifier = Modifier.height(15.dp))
//
//                    Text(
//                        text = "You're welcome",
//                        fontSize = 30.sp,
//                        color = Color.White
//                    )


//                    Text(
//                        text = stringResource(id = R.string.call),
//                        fontSize = 20.sp,
//                        modifier = Modifier
//                            .padding(16.dp)
//                            .clickable {
//
//                                val intent = Intent(Intent.ACTION_DIAL)
//                                intent.data = Uri.parse("tel:+254794842947")
//
//                                callLauncher.launch(intent)
//                            })
//

                }

            }

        },

        bottomBar = { BottomBar(navController = navController) }







    )

    AnimatedDrawer(
        isOpen = isDrawerOpen,
        onClose = { isDrawerOpen = false }
    )
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
        color = Color.DarkGray,
//       elevation = 16.dp
    )


    {
        Column {
            Text(
                modifier = Modifier,
                 color = Color.Red,
                fontSize = 25.sp,
                textAlign = TextAlign.Center,

                text = "Contact:")
            Text(
                modifier = Modifier
                    .padding(20.dp)
                    .clickable {
                        val intent = Intent(Intent.ACTION_DIAL)
                        intent.data = Uri.parse("tel:+254794842947")
                        callLauncher.launch(intent)
                    },
                color = Color.Cyan,
                text = "i) UNDRR"
            )


            Text(
                modifier = Modifier
                    .padding(20.dp)
                    .clickable {
                        val intent = Intent(Intent.ACTION_DIAL)
                        intent.data = Uri.parse("tel:+254 20 221 2386 ")
                        callLauncher.launch(intent)
                    },
                color = Color.Cyan,
                text = "ii) NDOC"
            )
            Text(
                modifier = Modifier
                    .padding(20.dp)
                    .clickable {
                        val intent = Intent(Intent.ACTION_DIAL)
                        intent.data = Uri.parse("tel:+254 20 762 1234")
                        callLauncher.launch(intent)
                    },
                color = Color.Cyan,
                text = "iii) UNEP",

                )
            Text(
                modifier = Modifier
                    .padding(20.dp)
                    .clickable {
                        val intent = Intent(Intent.ACTION_DIAL)
                        intent.data = Uri.parse("tel:+41 22 730 4222")
                        callLauncher.launch(intent)
                    },
                color = Color.Cyan,
                text = "iv) RED CROSS"
            )
            Spacer(modifier = Modifier.height(16.dp))
//            Text(text = stringResource(id = R.string.developer))

        }
    }
}






@Composable
fun BottomBar(navController: NavHostController) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        elevation = 10.dp,
        backgroundColor = Color.Black


    ) {

//        BottomNavigationItem(icon = {
//            Icon(imageVector = Icons.Default.Home,"", tint = Color.White)
//        },
//            label = { Text(text = "Home",color =  Color.White) },
//            selected = (selectedIndex.value == 0), onClick = {
//                navController.navigate(ROUTE_SEARCH) {
//                    popUpTo(ROUTE_HOME) { inclusive = true }
//                }
//            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Info,"",tint = Color.White)
        },
            label = { Text(text = "More info",color =  Color.White) },
            selected = (selectedIndex.value == 1), onClick = {
                navController.navigate(ROUTE_ABOUT) {
                    popUpTo(ROUTE_HOME) { inclusive = true }
                }
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.MoreVert, "",tint = Color.White)
        },
            label = { Text(
                text = "Learn More",
                color =  Color.White) },
            selected = (selectedIndex.value == 2),
            onClick = {

                navController.navigate(ROUTE_SEARCH) {
                    popUpTo(ROUTE_HOME) { inclusive = true }
                }

            })

    }

}