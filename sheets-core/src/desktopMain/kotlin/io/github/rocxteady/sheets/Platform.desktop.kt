package io.github.rocxteady.sheets

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Popup

actual enum class SecureFlagPolicy {
    Inherit,
}

actual val defaultWindowSoftInputMode: Int = 0

actual val hasLightNavigationBar: Boolean = false

internal actual fun currentTimeMillis(): Long = System.currentTimeMillis()

@Composable
internal actual fun SheetHost(
    state: BottomSheetState,
    behaviors: DialogSheetBehaviors,
    showAboveKeyboard: Boolean,
    onDismissRequest: () -> Unit,
    content: @Composable () -> Unit,
) {
    Popup(onDismissRequest = onDismissRequest) {
        content()
    }
}
