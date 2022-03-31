package com.example.chucknorrisjokeapp.view

import android.app.AlertDialog
import android.content.DialogInterface
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.chucknorrisjokeapp.databinding.FragmentMainBinding
import com.example.chucknorrisjokeapp.model.JokeItem
import com.example.chucknorrisjokeapp.viewmodel.JokeLoadingState
import com.example.chucknorrisjokeapp.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainFragment : Fragment() {

    private val binding by lazy { FragmentMainBinding.inflate(layoutInflater)}

    private val viewModel: MainViewModel by sharedViewModel()
    //private lateinit var jokesViewModel: MainViewModel

    //private lateinit var jokeRepo: JokeRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

//        viewModel = ViewModelProvider(this, JokeFactory(jokeRepo))
//            .get(viewModel::class.java)



        binding.randomJokeButton.setOnClickListener{

            viewModel.getRandomJoke("")
            val joke = viewModel.jokesLiveData.value.toString()

                AlertDialog.Builder(this.requireContext())
                    .setMessage(joke)
                    .setCancelable(true)
                    .setNegativeButton("Ok", DialogInterface.OnClickListener
                    { dialog, id -> dialog.cancel() })
                    .create().show()
        }


        binding.customJokeButton.setOnClickListener{

            viewModel.getCustomJoke("John", "Doe", "")
            val joke = viewModel.jokesLiveData.value.toString()

            AlertDialog.Builder(this.requireContext())
                .setMessage(joke)
                .setCancelable(true)
                .setNegativeButton("Ok", DialogInterface.OnClickListener
                { dialog, id -> dialog.cancel() })
                .create().show()

        }

        binding.multipleJokesButton.setOnClickListener{

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