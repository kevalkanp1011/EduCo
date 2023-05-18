package dev.kevalkanpariya.featuretesteduco.core.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.kevalkanpariya.featuretesteduco.core.domain.models.BottomNavBar
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey700
import dev.kevalkanpariya.featuretesteduco.ui.theme.HintGray
import dev.kevalkanpariya.featuretesteduco.ui.theme.SpaceSmall

@Composable
@Throws(IllegalArgumentException::class)
fun RowScope.StandardBottomNavItem(
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    contentDescription: String? = null,
    selected: Boolean = false,
    selectedColor: Color = MaterialTheme.colors.primary,
    unselectedColor: Color = HintGray,
    enabled: Boolean = true,
    onClick: () -> Unit
) {

    BottomNavigationItem(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        selectedContentColor = selectedColor,
        unselectedContentColor = unselectedColor,
        icon = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(SpaceSmall)
            ) {
                if(icon != null) {
                    Icon(
                        imageVector = icon,
                        contentDescription = contentDescription,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            }
        }
    )
}

/*@Composable
fun BottomNavigationBar(
    route:String,
    onItemSelected: (BottomNavBar) -> Unit
) {
    val items = BottomNavBar.Items.list

    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEach{ item ->
            BottomNavigationItem(item = item, isSelected = item.route == route) {
                onItemSelected(item)
            }
        }
    }

}
*/
@Composable
fun CustomBottomNavigationItem(item: BottomNavBar, isSelected: Boolean, onClick: () -> Unit) {
    val background = if (isSelected) MaterialTheme.colors.primary else Color.Transparent
    val contentColor = if (isSelected) Color.White else MaterialTheme.colors.onBackground

    Box(
        modifier = Modifier
            .clickable(onClick = onClick)
    ){
        Row(
            modifier = Modifier
                .padding(8.dp),
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
