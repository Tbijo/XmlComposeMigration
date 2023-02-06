package com.plcoding.xmlcomposemigration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var composeView: ComposeView

    private val viewModel: FirstViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).also {
            // initialize our composeView with this ComposeView
            composeView = it
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // setting content to our compose view
        composeView.setContent {
            val state by viewModel.state.collectAsState()
            FirstScreen(
                state = state,
                onNextClick = {
                    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                }
            )
        }
        // now delete XML layout and remove tools:layout from Navigation Graph
    }

}