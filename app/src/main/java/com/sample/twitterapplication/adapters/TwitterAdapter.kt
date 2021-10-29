package com.sample.twitterapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sample.twitterapplication.R
import com.sample.twitterapplication.model.Tweet

class TwitterAdapter(private val tweets: List<Tweet>): RecyclerView.Adapter<TwitterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TwitterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_tweet, parent, false)
        return TwitterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tweets.count()
    }

    override fun onBindViewHolder(holder: TwitterViewHolder, position: Int) {
        val tweet = tweets[position]
        holder?.let {
            holder.bindView(tweet)
        }
    }

}

class TwitterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    fun bindView(tweet: Tweet) {
        val userName = itemView.findViewById<TextView>(R.id.tvUserName)
        val text = itemView.findViewById<TextView>(R.id.tvPostMsg)

        userName.text = tweet.userName
        text.text = tweet.text
    }
}