package br.com.mobly.selection

import br.com.sdk.webservice.domain.JsonArticles

/**
 * create by enzo teles
 * */
class SelectionPresenter(var view: SelectionMVP.View) : SelectionMVP.Presenter{

    lateinit var iteractor: SelectionMVP.Iteractor
    /**
     * method load articles of the api
     * */
    override fun initData() {
        iteractor = SelectionIteractor(this)
        iteractor.getArticles()
    }

    /**
     * method to load articles of the api
     * @param articles
     * */
    override fun getArticles(articles: JsonArticles?) {
        view.getArticles(articles)
    }
}