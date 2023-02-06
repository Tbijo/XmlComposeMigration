package com.plcoding.xmlcomposemigration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

// Migrating FirstFragment

@Composable
fun FirstScreen(
    // do not inject viewModel if not necessary, to keep this screen flexible
    // initialize viewModel one layer above and pass the state
    state: FirstState,
    // Next expose the actions user can make on this screen (MVI arch.) to send to viewModel
    // Use a Action class
    onNextClick: () -> Unit
) {

    // This is how our fragment looks like
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This is our First Fragment.")
        Button(onClick = onNextClick) {
            Text(text = "Next")
        }
    }
}