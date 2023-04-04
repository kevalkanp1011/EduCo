package dev.kevalkanpariya.featuretesteduco.core.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

@Composable
fun VideoView(videoUri: String) {
    val context = LocalContext.current
    val exoPlayer = ExoPlayer
        .Builder(context)
        .build()
        .also { exoPlayer ->  
            val mediaItem = MediaItem.Builder()
                .setUri(videoUri)
                .build()
            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.prepare()

        }
    val lifecycleOwner = rememberUpdatedState(LocalLifecycleOwner.current)
    
    DisposableEffect(
        AndroidView(
            factory = {
            PlayerView(context).apply {
                player = exoPlayer
            }
                      },
            modifier = Modifier.fillMaxWidth().aspectRatio(16/9f)
        )
    ) {
        val observer = LifecycleEventObserver { owner, event ->
            when (event) {
                Lifecycle.Event.ON_PAUSE -> {
                    exoPlayer.pause()
                }
                Lifecycle.Event.ON_RESUME -> {
                    exoPlayer.play()
                }
                else -> {}
            }
        }
        val lifecycle = lifecycleOwner.value.lifecycle
        lifecycle.addObserver(observer)

        onDispose {
            exoPlayer.release()
            lifecycle.removeObserver(observer)
        }
    }

}

@Preview
@Composable
fun  TestExoPlayer() {
    Column(modifier = Modifier.padding(20.dp)) {
        VideoView(videoUri = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4")
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Video Player")
    }
    
}