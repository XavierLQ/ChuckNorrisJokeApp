package com.example.chucknorrisjokeapp.view

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorrisjokeapp.R
import com.example.chucknorrisjokeapp.databinding.FragmentMainBinding
import com.example.chucknorrisjokeapp.viewmodel.JokeLoadingState
import com.example.chucknorrisjokeapp.viewmodel.MainViewModel

class MainFragment : Fragment() {

    private val binding by lazy { FragmentMainBinding.inflate(layoutInflater)}

    private val viewModel: MainViewModel by viewModels()
//    private lateinit var jokesViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        jokesViewModel = ViewModelProvider(this, defaultViewModelProviderFactory)
//            .get(viewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding.randomJokeButton.setOnClickListener{

            viewModel.jokesLiveData.observe(viewLifecycleOwner) { state ->
                when(state) {

                    is JokeLoadingState.SUCCESS<*> ->

                    // build alert dialog
                        AlertDialog.Builder(this.requireContext())
                        .setMessage("")
                        .setCancelable(true)
                        .setNegativeButton("Ok", DialogInterface.OnClickListener {
                                dialog, id -> dialog.cancel()
                        }).create().show()

                    else -> {}
                }}


        }


        binding.customJokeButton.setOnClickListener{

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