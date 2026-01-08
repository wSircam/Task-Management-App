package com.wsircam.taskmanagement.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Archive
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.wsircam.taskmanagement.R

@Composable
fun MainBottomBar() {
    val homeResource = stringResource(R.string.bottom_menu_home)
    val projectsResource = stringResource(R.string.bottom_menu_projects)
    val archivedResource = stringResource(R.string.bottom_menu_archived)
    val profileResource = stringResource(R.string.bottom_menu_profile)
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = { },
            icon = {
                Icon(Icons.Default.Home, contentDescription = homeResource)
            },
            label = { Text(homeResource) }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    painterResource(R.drawable.outline_folder),
                    contentDescription = projectsResource
                )
            },
            label = { Text(projectsResource) }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(Icons.Default.Archive, contentDescription = archivedResource)
            },
            label = { Text(archivedResource) }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(Icons.Default.Person, contentDescription = profileResource)
            },
            label = { Text(profileResource) }
        )
    }
}
