package br.com.mobly.revision

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.mobly.R
import br.com.sdk.webservice.domain.ArticlesItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.revision_item_grid.view.*


class RevisionAdapterGrip(val articles: MutableList<ArticlesItem>, val context: Context) : RecyclerView.Adapter<RevisionAdapterGrip.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.revision_item_list, parent, false)
        return ViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var article = articles.get(position)
        (holder as ViewHolder).bindItem(position, article, articles)
    }

    class ViewHolder(itemView: View, var context: Context) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(position: Int, article: ArticlesItem, articles: MutableList<ArticlesItem>) {

            val drawable = article.media!![0]!!.uri
            Picasso.with(context).load(drawable).into(itemView.iv_article);
            itemView.tv_name.setText("${article.title}")
        }

    }
}

