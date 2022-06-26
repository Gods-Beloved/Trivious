package com.example.trivious.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.trivious.navigation.BottomNavScreen
import com.example.trivious.ui.theme.TriviousTheme
import com.example.trivious.ui.theme.triviousash_3

@Composable
fun CustomBottomNavigation(
    navController:NavHostController,

) {

    val items  = BottomNavScreen.Items.list

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination


    Surface(
        modifier = Modifier.padding(start = 6.dp, end = 6.dp, bottom = 8.dp),
        shape =RoundedCornerShape(40 ),

    ) {
        Row(
            modifier= Modifier
                .background(triviousash_3)
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            items.forEach { item->

                BottomNavItem(
                    item = item,
                    isSelected = currentDestination?.hierarchy?.any{
                        it.route == item.id
                    }== true
                ) {
                    navController.navigate(item.id)
                }

            }

        }
    }




}

@Composable
fun BottomNavItem(

    item: BottomNavScreen,
    isSelected:Boolean,
    onClick:()->Unit) {



    val background = if (isSelected) Color.Black.copy(alpha = 0.2f) else Color.Transparent

    val contentColor = if(isSelected) Color.Black else MaterialTheme.colors.onBackground

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .clickable {
                onClick()
            }

    ){
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Icon(painter = painterResource(id = item.icon), contentDescription = null, tint = contentColor)

            AnimatedVisibility(visible = isSelected) {
                Text(text = item.title, color = contentColor, style = MaterialTheme.typography.caption)
            }

        }

    }

}

@Preview(widthDp = 320)
@Composable
fun CustomNavPreview() {
    TriviousTheme() {
        CustomBottomNavigation(navController = rememberNavController())

    }
}

@Preview
@Composable
fun CustomNavItemPreview() {
    TriviousTheme() {
        BottomNavItem(item = BottomNavScreen.Home, isSelected = true) {


        }
    }

}