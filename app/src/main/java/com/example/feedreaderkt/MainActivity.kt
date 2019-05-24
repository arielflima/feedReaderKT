package com.example.feedreaderkt

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.pkmmte.pkrss.Article
import com.pkmmte.pkrss.Callback
import com.pkmmte.pkrss.PkRSS

class MainActivity : AppCompatActivity(), Callback {

    val listItems = arrayListOf<Item>()

    override fun onLoadFailed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPreload() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLoaded(newArticles: MutableList<Article>?) {
        newArticles?.mapTo(listItems) {
            Item(it.title, it.author, it.date, it.source, it.enclosure.url)
        }
    }

    data class Item(val titulo: String, val autor: String, val data: Long, val link: Uri, val image: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PkRSS.with(this).load("https://rss.tecmundo.com.br/feed").callback(this).async()
    }
}
