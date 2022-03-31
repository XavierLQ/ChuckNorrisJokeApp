package com.example.chucknorrisjokeapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorrisjokeapp.R
import com.example.chucknorrisjokeapp.model.JokeItem
import com.example.chucknorrisjokeapp.model.JokeList
import com.example.chucknorrisjokeapp.model.Jokes

class JokeAdapter(
    private val jokes:MutableList<JokeItem> = mutableListOf()): RecyclerView.Adapter<JokeAdapter.JokeViewHolder>(){

    fun updateJokes(newJokes: List<JokeItem>){
        jokes.clear()
        jokes.addAll(newJokes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val jokeView = LayoutInflater.from(parent.context).inflate(R.layout.joke_item, parent, false)
        return JokeViewHolder(jokeView)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val JokeSelect = jokes[position]
        holder.bind(JokeSelect)
    }

    override fun getItemCount(): Int = jokes.size


    class JokeViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val jokeItem: TextView = itemView.findViewById(R.id.joke_card)

        fun bind(joke:JokeItem){
            jokeItem.text = joke.joke
        }
    }
}