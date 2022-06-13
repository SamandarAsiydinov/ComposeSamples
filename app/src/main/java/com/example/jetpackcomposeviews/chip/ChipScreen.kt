package com.example.jetpackcomposeviews.chip

import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.jetpackcomposeviews.chip.component.fadeInDiagonalGradientBorder
import com.example.jetpackcomposeviews.chip.component.offsetGradientBackground
import com.example.jetpackcomposeviews.chip.model.Filter
import com.example.jetpackcomposeviews.chip.utils.Constants
import com.example.jetpackcomposeviews.list_item.util.ObjectList
import com.example.jetpackcomposeviews.ui.theme.Purple200
import com.example.jetpackcomposeviews.ui.theme.Purple500
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import kotlin.math.ln

@Composable
fun ChipScreen() {
    val filters = Constants.fruitFilters
    val context = LocalContext.current

    Column(
        modifier = Modifier.padding(10.dp),
    ) {
        FlowRow(
            mainAxisAlignment = FlowMainAxisAlignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 16.dp)
                .padding(horizontal = 4.dp)
        ) {
            filters.forEach { filter ->
                FilterChip(
                    filter = filter,
                    modifier = Modifier.padding(end = 4.dp, bottom = 8.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {
                filters.forEach { fruit ->
                    if (fruit.enabled.value) {
                        Toast.makeText(context, fruit.name, Toast.LENGTH_SHORT).show()
                    }
                }
            },
            modifier = Modifier.clip(RoundedCornerShape(5.dp))
        ) {
            Text(
                text = "Enter",
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}

@Composable
fun FilterChip(
    filter: Filter,
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.small
) {
    val (selected, setSelected) = filter.enabled
    val backgroundColor by animateColorAsState(
        if (selected) Purple500 else Color.White
    )
    val border = Modifier.fadeInDiagonalGradientBorder(
        showBorder = !selected,
        colors = listOf(
            Purple500, Purple200
        ),
        shape = shape
    )
    val textColor by animateColorAsState(
        if (selected) Color.White else Color.Black
    )
    ChipSurface(
        modifier = modifier.height(40.dp),
        color = backgroundColor,
        contentColor = textColor,
        shape = shape,
        elevation = 2.dp
    ) {
        val interactSource = remember { MutableInteractionSource() }

        val pressed by interactSource.collectIsPressedAsState()
        val backgroundPressed =
            if (pressed) {
                Modifier.offsetGradientBackground(
                    listOf(
                        Purple500, Purple200
                    ),
                    200f,
                    0f
                )
            } else {
                Modifier.background(Color.Transparent)
            }
        Box(
            modifier = Modifier
                .toggleable(
                    value = selected,
                    onValueChange = setSelected,
                    interactionSource = interactSource,
                    indication = null
                )
                .then(backgroundPressed)
                .then(border)
                .height(40.dp)
        ) {
            Text(
                text = filter.name,
                style = MaterialTheme.typography.caption,
                maxLines = 1,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 6.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun ChipSurface(
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    color: Color = Purple500,
    contentColor: Color = Purple200,
    border: BorderStroke? = null,
    elevation: Dp = 0.dp,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .shadow(elevation, shape, false)
            .zIndex(elevation.value)
            .then(if (border != null) Modifier.border(border, shape) else Modifier)
            .background(
                color = getBackgroundColorForElevation(color = color, elevation = elevation),
                shape = shape
            )
            .clip(shape)
    ) {
        CompositionLocalProvider(LocalContentColor provides contentColor, content = content)
    }
}

@Composable
private fun getBackgroundColorForElevation(color: Color, elevation: Dp): Color {
    return if (elevation > 0.dp)
        color.withElevation(elevation)
    else
        color
}

private fun calculateForeground(elevation: Dp): Color {
    val alpha = ((4.5f * ln(elevation.value + 1)) + 2f) / 100f
    return Color.White.copy(alpha = alpha)
}

private fun Color.withElevation(elevation: Dp): Color {
    val foreground = calculateForeground(elevation)
    return foreground.compositeOver(this)
}