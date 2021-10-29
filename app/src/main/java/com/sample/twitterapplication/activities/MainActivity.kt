package com.sample.twitterapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sample.twitterapplication.R
import com.sample.twitterapplication.adapters.TwitterAdapter
import com.sample.twitterapplication.model.Tweet

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rvTweets)
        recyclerView.adapter = TwitterAdapter(getTweets())

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
    }

    private fun getTweets(): List<Tweet> {
        return listOf(
                Tweet("Renan", "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
                        "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
                        "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi "),
                Tweet("Maria da Silva", "Sed ut perspiciatis unde omnis iste natus error sit " +
                        "voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque " +
                        "ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae " +
                        "dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit " +
                        "aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos " +
                        "qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui " +
                        "dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia " +
                        "non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam " +
                        "quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem" +
                        " ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi " +
                        "consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate " +
                        "velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum " +
                        "fugiat quo voluptas nulla pariatur?"),
                Tweet("João Barbosa", "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
                        "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
                        "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ")
        )
    }

}