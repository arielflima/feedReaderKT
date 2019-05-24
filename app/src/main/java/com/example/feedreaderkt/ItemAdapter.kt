package com.example.feedreaderkt

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class ItemAdapter(val list: ArrayList<MainActivity.Item>, val context: Context) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onBindViewHolder(p0: ItemViewHolder, p1: Int) {
        p0?.titulo?.text = list[p1].titulo
        p0?.autor?.text = list[p1].autor
        p0?.data?.text = SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR")).format(Date(list[p1].data))
        p0?.buttonVerMais?.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, list[p1].link)
            context.startActivity(intent)
        }
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titulo = view.findViewById<TextView>(R.id.textTitulo)
        val autor = view.findViewById<TextView>(R.id.textAutor)
        val data = view.findViewById<TextView>(R.id.textData)
        val imagem = view.findViewById<ImageView>(R.id.imageView)
        val buttonVerMais = view.findViewById<Button>(R.id.buttonVerMais)

    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ItemViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.item_list, p0, false)
        val lvh = ItemViewHolder(v)

        return lvh
    }

    override fun getItemCount(): Int = list.size


}