package com.example.chucknorrisjokeapp.view

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chucknorrisjokeapp.Adapter.JokeAdapter
import com.example.chucknorrisjokeapp.R
import com.example.chucknorrisjokeapp.databinding.FragmentCustomJokeBinding
import com.example.chucknorrisjokeapp.databinding.FragmentJokeListBinding
import com.example.chucknorrisjokeapp.model.JokeList
import com.example.chucknorrisjokeapp.model.Jokes
import com.example.chucknorrisjokeapp.viewmodel.JokeLoadingState
import com.example.chucknorrisjokeapp.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class JokeListFragment : Fragment() {

    private val binding by lazy {
        FragmentJokeListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private val jokeAdapter by lazy{
        JokeAdapter()
    }

    private val viewModel: MainViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.jokeRecycler.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = jokeAdapter
            viewModel.getMultipleJokes("")
        }

            viewModel.jokesLiveData.observe(viewLifecycleOwner) { state ->
                when (state) {

                    is JokeLoadingState.LOADING ->{Log.d("received jokes", state.toString())}

                    is JokeLoadingState.SUCCESS<*> -> {

                        val receivedJokes: JokeList? = state.response as? JokeList

                        if (receivedJokes != null) {
                            jokeAdapter.updateJokes(receivedJokes.value)
                        }

                            Log.d("received jokes", state.toString())

                        }

                    is JokeLoadingState.ERROR -> {
                        Log.d("received jokes", state.toString())

                    }
                }
            }






        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onResume() {
        super.onResume()



    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            JokeListFragment().apply {
            }
    }
}