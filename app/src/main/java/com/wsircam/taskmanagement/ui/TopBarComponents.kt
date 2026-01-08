package com.wsircam.taskmanagement.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.wsircam.taskmanagement.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(onMenuClick: () -> Unit) {
    TopAppBar(
        title = { },
        navigationIcon = {
            IconButton(
                onClick = {
                    onMenuClick.invoke()
                }
            ) {
                Icon(
                    Icons.Default.Menu,
                    contentDescription = stringResource(R.string.drawer_accessibility)
                )
            }
        }
    )
}
