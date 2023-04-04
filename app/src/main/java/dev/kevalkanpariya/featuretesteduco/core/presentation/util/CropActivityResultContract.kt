package dev.kevalkanpariya.featuretesteduco.core.presentation.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.result.contract.ActivityResultContract
import dev.kevalkanpariya.featuretesteduco.core.domain.util.getFileName
import java.io.File
import com.yalantis.ucrop.UCrop
import com.yalantis.ucrop.UCrop.RESULT_ERROR

class CropActivityResultContract(
    private val aspectRatioX: Float,
    private val aspectRatioY: Float,
) : ActivityResultContract<Uri, Uri?>() {

    override fun createIntent(context: Context, input: Uri): Intent {
        return UCrop.of(
            input,
            Uri.fromFile(
                File(
                    context.cacheDir,
                    context.contentResolver.getFileName(input)
                )
            )
        )
            .withAspectRatio(aspectRatioX, aspectRatioY)
            .getIntent(context)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Uri? {
        if (intent == null) {
            return null
        }
        if (resultCode == RESULT_ERROR) {
            val error = UCrop.getError(intent)
            error?.printStackTrace()
        }
        return UCrop.getOutput(intent)
    }
}