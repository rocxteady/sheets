package io.github.rocxteady.sheets

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

/**
 * A bottom sheet will be displayed in a dialog window.
 *
 * @param state The bottom sheet state. Call [rememberBottomSheetState] to create one.
 * @param modifier Modifier for bottom sheet content.
 * @param skipPeeked Skip the peeked state if set to true. Defaults to false.
 * @param peekHeight Peek height, could be a dp, px, or fraction value.
 * @param backgroundColor Background color for sheet content.
 * @param dimColor Dim color. Defaults to [Color.Black].
 * @param maxDimAmount Maximum dim amount. Defaults to 0.45f.
 * @param behaviors Dialog sheet behaviors. Including system bars, clicking, window input mode, etc.
 * @param contentAlignment The alignment of the content. Only works when the content width is
 * smaller than the screen width.
 * @param showAboveKeyboard Controls whether the whole bottom sheet should show above the soft
 * keyboard when the keyboard is shown. Defaults to false.
 * @param dragHandle Bottom sheet drag handle. A round bar was displayed by default.
 * @param content Sheet content.
 */
@Composable
fun BottomSheet(
    state: BottomSheetState,
    modifier: Modifier = Modifier,
    skipPeeked: Boolean = false,
    peekHeight: PeekHeight = PeekHeight.Companion.fraction(0.5f),
    shape: Shape = MaterialTheme.shapes.medium.copy(
        bottomStart = CornerSize(0.dp),
        bottomEnd = CornerSize(0.dp)
    ),
    backgroundColor: Color = MaterialTheme.colors.surface,
    dimColor: Color = Color.Black,
    maxDimAmount: Float = CoreBottomSheetDefaults.MaxDimAmount,
    behaviors: DialogSheetBehaviors = BottomSheetDefaults.dialogSheetBehaviors(),
    contentAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    showAboveKeyboard: Boolean = false,
    dragHandle: @Composable () -> Unit = { BottomSheetDragHandle() },
    gestureEnabled: Boolean = true,
    content: @Composable () -> Unit
) {
    CoreBottomSheet(
        state = state,
        modifier = modifier,
        skipPeeked = skipPeeked,
        peekHeight = peekHeight,
        shape = shape,
        backgroundColor = backgroundColor,
        dimColor = dimColor,
        maxDimAmount = maxDimAmount,
        behaviors = behaviors,
        contentAlignment = contentAlignment,
        showAboveKeyboard = showAboveKeyboard,
        dragHandle = dragHandle,
        gestureEnabled = gestureEnabled,
        content = content,
    )
}

/**
 * A bottom sheet layout will be embedded in the composable directly.
 *
 * @param state The bottom sheet state. Call [rememberBottomSheetState] to create one.
 * @param modifier Modifier for bottom sheet content.
 * @param skipPeeked Skip the peeked state if set to true. Defaults to false.
 * @param peekHeight Peek height, could be a dp, px, or fraction value.
 * @param backgroundColor Background color for sheet content.
 * @param dimColor Dim color. Defaults to [Color.Black].
 * @param maxDimAmount Maximum dim amount. Defaults to 0.45f.
 * @param behaviors Dialog sheet behaviors. Including system bars, clicking, window input mode, etc.
 * @param contentAlignment The alignment of the content. Only works when the content width is
 * smaller than the screen width.
 * @param dragHandle Bottom sheet drag handle. A round bar was displayed by default.
 * @param content Sheet content.
 */
@Composable
fun BottomSheetLayout(
    state: BottomSheetState,
    modifier: Modifier = Modifier,
    skipPeeked: Boolean = false,
    peekHeight: PeekHeight = PeekHeight.Companion.fraction(0.5f),
    shape: Shape = MaterialTheme.shapes.medium.copy(
        bottomStart = CornerSize(0.dp),
        bottomEnd = CornerSize(0.dp)
    ),
    backgroundColor: Color = MaterialTheme.colors.surface,
    dimColor: Color = Color.Black,
    maxDimAmount: Float = CoreBottomSheetDefaults.MaxDimAmount,
    behaviors: SheetBehaviors = SheetBehaviors(),
    contentAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    dragHandle: @Composable () -> Unit = { BottomSheetDragHandle() },
    gestureEnabled: Boolean = true,
    content: @Composable () -> Unit
) {
    CoreBottomSheetLayout(
        state = state,
        modifier = modifier,
        skipPeeked = skipPeeked,
        peekHeight = peekHeight,
        shape = shape,
        backgroundColor = backgroundColor,
        dimColor = dimColor,
        maxDimAmount = maxDimAmount,
        behaviors = behaviors,
        contentAlignment = contentAlignment,
        dragHandle = dragHandle,
        gestureEnabled = gestureEnabled,
        content = content,
    )
}