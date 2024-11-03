package io.github.rocxteady.sheets.sample

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.rocxteady.sheets.BottomSheetState

@Composable
expect fun IntentPickerSheetContent(
    state: BottomSheetState,
    modifier: Modifier = Modifier,
)