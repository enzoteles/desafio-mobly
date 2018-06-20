package br.com.mobly.selection

import br.com.sdk.webservice.domain.JsonArticles

interface SelectionMVP{
    interface View{
        fun initUI()
        fun initData()
        fun getArticles(articles: JsonArticles?)

    }
    interface Presenter {
        fun initData()
        fun getArticles(articles: JsonArticles?)
    }

    interface Iteractor {
        fun getArticles()
    }
}