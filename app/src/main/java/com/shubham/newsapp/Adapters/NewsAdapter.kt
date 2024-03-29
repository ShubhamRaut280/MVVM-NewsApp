package com.shubham.newsapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shubham.newsapp.Models.api.Article
import com.shubham.newsapp.R

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.holder>() {


    // diffutils
    private val differCallback = object : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem==newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)








    inner class holder(itemView : View): RecyclerView.ViewHolder(itemView){
        var image = itemView.findViewById<ImageView>(R.id.ivArticleImage)
        var title = itemView.findViewById<TextView>(R.id.tvTitle)
        var source = itemView.findViewById<TextView>(R.id.tvSource)
        var description = itemView.findViewById<TextView>(R.id.tvDescription)
        var publishedAt = itemView.findViewById<TextView>(R.id.tvPublishedAt)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        return holder(LayoutInflater.from(parent.context).inflate( R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: holder, position: Int) {
        var article : Article = differ.currentList[position]

        holder.itemView.apply {
            Glide.with(this).load(article.urlToImage).into(holder.image)
            holder.description.text = article.description
            holder.source.text = article.source.name
            holder.title.text = article.title
            holder.publishedAt.text = article.publishedAt

        }

        holder.itemView.setOnClickListener{

        }
    }
}