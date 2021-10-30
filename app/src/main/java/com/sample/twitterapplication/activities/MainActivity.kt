package com.sample.twitterapplication.activities

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.twitterapplication.R
import com.sample.twitterapplication.adapters.TwitterAdapter
import com.sample.twitterapplication.api.Endpoint
import com.sample.twitterapplication.model.Statuses
import com.sample.twitterapplication.utils.FeedBackUtils.showDialog
import com.sample.twitterapplication.utils.NetworkUtils
import com.sample.twitterapplication.utils.RESULT_TYPE_RECENT
import com.sample.twitterapplication.utils.Utils.closeSoftKeyboard
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


class MainActivity : AppCompatActivity(), TextView.OnEditorActionListener {

    lateinit var recyclerView : RecyclerView
    lateinit var edtSearch : EditText

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        edtSearch = findViewById(R.id.edtSearch)
        recyclerView = findViewById(R.id.rvTweets)
        recyclerView.adapter = TwitterAdapter(listOf())

        edtSearch.setOnEditorActionListener(this)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun getData(query: String) {
        val retrofitClient = NetworkUtils.getRetrofitInstance()

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getPosts(query, RESULT_TYPE_RECENT)

        callback.enqueue(object : Callback<Statuses> {
            override fun onResponse(call: Call<Statuses>, response: Response<Statuses>) {
                val tweets = response.body()?.statuses.orEmpty()
                recyclerView.adapter = TwitterAdapter(tweets)
            }

            override fun onFailure(call: Call<Statuses>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
                showDialog(this@MainActivity, getString(R.string.warning_dialog_title),
                    getString(R.string.warning_dialog_message))
            }
        })
    }

    override fun onEditorAction(v: TextView?, actionId: Int, keyEvent: KeyEvent?): Boolean {
        if(actionId == EditorInfo.IME_ACTION_SEARCH){
            getData(v?.text.toString())
            closeSoftKeyboard(this, edtSearch)
            return true
        }
        return false
    }
}