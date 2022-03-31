package com.example.chucknorrisjokeapp.view

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.chucknorrisjokeapp.R
import com.example.chucknorrisjokeapp.databinding.FragmentCustomJokeBinding
import com.example.chucknorrisjokeapp.model.Jokes
import com.example.chucknorrisjokeapp.viewmodel.JokeLoadingState
import com.example.chucknorrisjokeapp.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class CustomJokeFragment : Fragment() {

    private val binding by lazy {
        FragmentCustomJokeBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by sharedViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        viewModel.getCustomJoke("", "", "")
        binding.customJokeButton2.setOnClickListener {
            var firstName = binding.firstNameEditText.text.toString()
            var lastName = binding.lastNameEditText.text.toString()
            viewModel.getCustomJoke(firstName, lastName, "")


            viewModel.jokesLiveData.observe(viewLifecycleOwner) { state ->
                when (state) {
                    is JokeLoadingState.SUCCESS<*> -> {

                        val jokeReceived = state.response as? Jokes

                        binding.customJokeButton2.setOnClickListener {
                            AlertDialog.Builder(this.requireContext())
                                .setMessage(jokeReceived?.value?.joke)
                                .setCancelable(true)
                                .setNegativeButton("Ok", DialogInterface.OnClickListener
                                { dialog, id -> dialog.cancel() })
                                .create().show()

                            viewModel.getCustomJoke("", "", "")
                        }
                    }
                    is JokeLoadingState.ERROR -> {
                        Toast.makeText(
                            requireContext(),
                            state.error.localizedMessage,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }


        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            JokeListFragment().apply {
            }
    }
}