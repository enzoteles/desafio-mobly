package br.com.mobly.selection.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import br.com.enzoteles.quickhelp.log.HelpLog
import br.com.mobly.Constant
import br.com.mobly.R
import br.com.sdk.webservice.domain.ArticlesItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.selection_item.view.*
import android.widget.CompoundButton



class SelectionAdapter(val articles: MutableList<ArticlesItem>, val context: Context) : RecyclerView.Adapter<SelectionAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.selection_item, parent, false)
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

            itemView.cb_liked.setOnCheckedChangeListener(null)
            itemView.cb_liked.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->

                if(isChecked){
                    itemView.cb_liked.setBackgroundResource(R.drawable.like_2)
                    Constant.countLike = Constant.countLike!! + 1
                    article.checkSeleced = true
                    if(article.checkSeleced!!){
                        Constant.tv_liked!!.text = "${Constant.countLike}/10"
                    }

                }else{
                    itemView.cb_liked.setBackgroundResource(R.drawable.like_1)
                    article.checkSeleced = false
                    if (Constant.countLike != 0) {
                        if(!article.checkSeleced!!){
                            Constant.countLike = Constant.countLike!! - 1
                            Constant.tv_liked!!.text = "${Constant.countLike}/10"
                        }

                    }
                }
            })
            itemView.cb_liked.setChecked(article.checkSeleced!!)
        }

    }
}

