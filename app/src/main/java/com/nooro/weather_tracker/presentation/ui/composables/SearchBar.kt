package com.nooro.weather_tracker.presentation.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    onSearch: (String) -> Unit,
    focusRequester: FocusRequester
) {
    var searchText by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        value = searchText,
        onValueChange = { searchText = it },
        label = { Text("Search Location") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .focusRequester(focusRequester),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search"
            )
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearch(searchText)
                keyboardController?.hide()
                focusRequester.freeFocus()
            }
        )
    )
}