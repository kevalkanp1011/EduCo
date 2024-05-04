package dev.kevalkanpariya.educo.feature_course.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.material.ScaffoldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.UiComposable
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastMap
import androidx.compose.ui.util.fastMaxBy

@Composable
@UiComposable
fun ScaffoldWithBottomBar(
    bottomBar: @Composable @UiComposable () -> Unit ={},
    content: @Composable @UiComposable (PaddingValues) -> Unit ={},

    ) {

    SubcomposeLayout { constraints ->
        val layoutWidth = constraints.maxWidth
        val layoutHeight = constraints.maxHeight

        val looseConstraints = constraints.copy(minWidth = 0, minHeight = 0)

        layout(layoutWidth, layoutHeight) {
            val bottomBarPlaceables = subcompose("bottombar") {
                CompositionLocalProvider(
                    content = bottomBar
                )
            }.fastMap { it.measure(looseConstraints) }

            val bottomBarHeight = bottomBarPlaceables.fastMaxBy { it.height }?.height ?: 0

            // The bottom bar is always at the bottom of the layout
            bottomBarPlaceables.fastForEach {
                it.place(0, layoutHeight - bottomBarHeight)
            }

            val bodyContentHeight = layoutHeight

            val bodyContentPlaceables = subcompose("maincontent") {
                val insets = ScaffoldDefaults.contentWindowInsets.asPaddingValues(this@SubcomposeLayout)
                val innerPadding = PaddingValues(
                    top = insets.calculateTopPadding(),
                    bottom =
                    if (bottomBarPlaceables.isEmpty()) {
                        insets.calculateBottomPadding()
                    } else {
                        bottomBarHeight.toDp()
                    },
                    start = insets.calculateStartPadding((this@SubcomposeLayout).layoutDirection),
                    end = insets.calculateEndPadding((this@SubcomposeLayout).layoutDirection)
                )
                content(innerPadding)
            }.fastMap { it.measure(looseConstraints.copy(maxHeight = bodyContentHeight)) }

            // Placing to control drawing order to match default elevation of each placeable
            bodyContentPlaceables.fastForEach {
                it.place(0, 0)
            }
        }
    }
}