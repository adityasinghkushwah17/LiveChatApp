package com.example.livechatroom.Screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.livechatroom.DestinationScreen
import com.example.livechatroom.R


enum class BottomNavigationMenu( val icon:Int,val destinationScreen: DestinationScreen){
    CHATLIST(R.drawable.comment,DestinationScreen.ChatList),
    STATUS(R.drawable.updates,DestinationScreen.StatusList),
    PROFILE(R.drawable.user,DestinationScreen.Profile)

}
@Composable
fun BottomNavigationMenu(
    selecteditem: BottomNavigationMenu,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(4.dp)
            .background(Color.White),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceAround // Changed to SpaceAround for better spacing
    ) {
        for (item in BottomNavigationMenu.values()) {
            Image(
                painter = painterResource(id = item.icon),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .weight(1f)
                    .clickable {
                        navController.navigate(item.destinationScreen.route)
                    },
                colorFilter = if (item == selecteditem)
                    ColorFilter.tint(Color.Blue) else ColorFilter.tint(Color.Gray)
            )
        }
    }
}