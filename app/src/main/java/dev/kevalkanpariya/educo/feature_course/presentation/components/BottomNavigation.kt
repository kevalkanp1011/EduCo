package dev.kevalkanpariya.educo.feature_course.presentation.components


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.kevalkanpariya.educo.core.navigation.BottomNavItem
import dev.kevalkanpariya.educo.ui.theme.Grey700

@Composable
fun BottomNavigationBar(
    route:String,
    onItemSelected: (BottomNavItem) -> Unit
) {
    val items = BottomNavItem.Items.list

    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEach{ item ->
            BottomNavigationItem(item = item, isSelected = item.route == route) {
                onItemSelected(item)
            }
        }
    }

}

@Composable
fun BottomNavigationItem(item: BottomNavItem, isSelected: Boolean, onClick: () -> Unit) {
    val background = if (isSelected) MaterialTheme.colors.primary else Color.Transparent
    val contentColor = if (isSelected) Color.White else MaterialTheme.colors.onBackground


    
    Box(
        modifier = Modifier
            .clickable(onClick = onClick)
    ){
        Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                painter = painterResource(id = item.icon),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(background)
                    .padding(10.dp),
                tint = contentColor
            )
            
            AnimatedVisibility(visible = isSelected) {
                Text(text = item.title, color = Grey700)
            }
        }
    }
}
