package com.sample.twitterapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sample.twitterapplication.R
import com.sample.twitterapplication.model.Tweet
import com.sample.twitterapplication.utils.AT
import com.sample.twitterapplication.utils.DateUtils
import com.sample.twitterapplication.utils.HOUR_SUFFIX

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
        holder.let {
            holder.bindView(tweet)
        }
    }

}

class TwitterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindView(tweet: Tweet) {
        val tvUserName = itemView.findViewById<TextView>(R.id.tvUserName)
        val tvText = itemView.findViewById<TextView>(R.id.tvPostMsg)
        val tvRetweetCount = itemView.findViewById<TextView>(R.id.tvReTwittedCount)
        val tvFavoriteCount = itemView.findViewById<TextView>(R.id.tvLikesCount)
        val tvScreenName = itemView.findViewById<TextView>(R.id.tvUserAccountName)
        val tvHour = itemView.findViewById<TextView>(R.id.tvHour)
        val ivUserPic = itemView.findViewById<ImageView>(R.id.ivUserPic)

        tvUserName.text = tweet.user.name
        tvScreenName.text = AT.plus(tweet.user.screenName)
        tvText.text = tweet.text
        tvHour.text = DateUtils.getHour(tweet.createdAt).plus(HOUR_SUFFIX)
        tvRetweetCount.text = tweet.retweetCount.toString()
        tvFavoriteCount.text = tweet.favoriteCount.toString()

        Glide.with(itemView)
                .load(tweet.user.profileImageUrl)
                .circleCrop()
                .into(ivUserPic)
    }
}