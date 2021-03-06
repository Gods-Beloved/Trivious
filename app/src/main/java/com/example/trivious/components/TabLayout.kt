package com.example.trivious.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.trivious.presentation.mainscreen.home.academic.AcademicScreen
import com.example.trivious.presentation.mainscreen.home.entertainment.EntertainmentScreen
import com.example.trivious.presentation.mainscreen.home.live.LiveScreen
import com.example.trivious.presentation.mainscreen.home.sport.SportScreen
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class, ExperimentalUnitApi::class)
@Composable
fun TabLayout(
    navController: NavController
) {

    val pagerState = rememberPagerState(pageCount = 4)

    // on below line we are creating a column for our widgets.
    Column(
        // for column we are specifying modifier on below line.
        modifier = Modifier.background(Color.White)
    ) {
       Divider(modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colors.primary)

        // on below line we are calling tabs
        Tabs(pagerState = pagerState)
        // on below line we are calling tabs content
        // for displaying our page for each tab layout
        TabsContent(pagerState = pagerState, navController = navController)
    }



}

@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {
    // in this function we are creating a list
    // in this list we are specifying data as
    // name of the tab and the icon for it.
    val list = listOf(
        "Live" ,
        "Academic" ,
        "Entertainment",
        "Sport"

    )
    // on below line we are creating
    // a variable for the scope.
    val scope = rememberCoroutineScope()
    // on below line we are creating a
    // individual row for our tab layout.
    ScrollableTabRow(

        // on below line we are specifying
        // the selected index.
edgePadding = 0.dp,
        selectedTabIndex = pagerState.currentPage,



        // on below line we are
        // specifying background color.
        backgroundColor = Color.Black,

        // on below line we are specifying content color.
        contentColor = Color.White,

        // on below line we are specifying
        // the indicator for the tab
        indicator = { tabPositions ->
            // on below line we are specifying the styling
            // for tab indicator by specifying height
            // and color for the tab indicator.

            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = MaterialTheme.colors.primary
            )
            TabRowDefaults.ScrollableTabRowPadding
        }
    ) {
        // on below line we are specifying icon
        // and text for the individual tab item
        list.forEachIndexed { index, _ ->
            // on below line we are creating a tab.
            Tab(
                // on below line we are specifying icon
                // for each tab item and we are calling
                // image from the list which we have created.

                // on below line we are specifying the text for
                // the each tab item and we are calling data
                // from the list which we have created.
                text = {
                    Text(
                        list[index],
                        // on below line we are specifying the text color
                        // for the text in that tab
                        color = if (pagerState.currentPage == index) MaterialTheme.colors.primary else Color.LightGray
                    )
                },
                // on below line we are specifying
                // the tab which is selected.
                selected = pagerState.currentPage == index,
                // on below line we are specifying the
                // on click for the tab which is selected.
                onClick = {
                    // on below line we are specifying the scope.
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}

@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState, navController: NavController) {
    // on below line we are creating
    // horizontal pager for our tab layout.

    HorizontalPager(state = pagerState) {
        // on below line we are specifying
        // the different pages.
            page ->
        when (page) {
            // on below line we are calling tab content screen
            // and specifying data as Home Screen.
            0 -> LiveScreen(title = "Live", navController = navController)
            // on below line we are calling tab content screen
            // and specifying data as Shopping Screen.
            1 -> AcademicScreen(title = "Academic")
            // on below line we are calling tab content screen
            // and specifying data as Settings Screen.
            2 -> EntertainmentScreen(title = "Entertainment" )

            3 -> SportScreen(title = "Sport")
        }
    }
}




