package com.wsircam.taskmanagement.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wsircam.taskmanagement.MainContainer
import com.wsircam.taskmanagement.R

@Composable
fun MainDrawer() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            MainDrawerContent()
        }
    ) {
        MainContainer(scope, drawerState)
    }
}


@Composable
fun MainDrawerContent() {
    ModalDrawerSheet {
        DrawerSection(stringResource(R.string.drawer_section_general))
        DrawerItem(stringResource(R.string.drawer_menu_labels)) {}
        DrawerItem(stringResource(R.string.drawer_menu_priorities)) {}
        Spacer(Modifier.height(8.dp))
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            color = MaterialTheme.colorScheme.surfaceVariant
        )
        DrawerSection(stringResource(R.string.drawer_section_app))
        DrawerItem(stringResource(R.string.drawer_menu_settings)) {}
        DrawerItem(stringResource(R.string.drawer_menu_about)) {}
    }
}

@Composable
fun DrawerSection(title: String) {
    Text(
        text = title.uppercase(),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 12.dp),
        style = MaterialTheme.typography.labelSmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
}

@Composable
fun DrawerItem(
    text: String,
    onClick: () -> Unit
) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp)
    )
}

@Composable
@Preview(
    showBackground = true,
)
fun DrawerPreview() {
    MainDrawerContent()
}
