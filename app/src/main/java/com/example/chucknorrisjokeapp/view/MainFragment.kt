package com.example.chucknorrisjokeapp.view

import android.app.AlertDialog
import android.content.DialogInterface
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.chucknorrisjokeapp.R
import com.example.chucknorrisjokeapp.databinding.FragmentMainBinding
import com.example.chucknorrisjokeapp.model.JokeItem
import com.example.chucknorrisjokeapp.model.Jokes
import com.example.chucknorrisjokeapp.viewmodel.JokeLoadingState
import com.example.chucknorrisjokeapp.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainFragment : Fragment() {

    private val binding by lazy { FragmentMainBinding.inflate(layoutInflater)}

    private val viewModel: MainViewModel by sharedViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

            viewModel.getRandomJoke("")
            viewModel.jokesLiveData.observe(viewLifecycleOwner) { state ->
                when (state) {
                    is JokeLoadingState.SUCCESS<*> -> {

                        val jokeReceived = state.response as? Jokes

                        binding.randomJokeButton.setOnClickListener {
                            AlertDialog.Builder(this.requireContext())
                                .setMessage(jokeReceived?.value?.joke)
                                .setCancelable(true)
                                .setNegativeButton("Ok", DialogInterface.OnClickListener
                                { dialog, id -> dialog.cancel() })
                                .create().show()

                            viewModel.getRandomJoke("")
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


        binding.customJokeButton.setOnClickListener{
            findNavController()
                .navigate(R.id.action_mainFragment_to_customJokeFragment)
        }

        binding.multipleJokesButton.setOnClickListener{
            findNavController()
                .navigate(R.id.action_mainFragment_to_jokeListFragment)
        }


        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MainFragment().apply {
            }
    }
}