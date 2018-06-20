package br.com.mobly.selection

import br.com.sdk.webservice.service.MoblyApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * create by enzo teles
 * */
class SelectionIteractor(var presenter: SelectionMVP.Presenter) : SelectionMVP.Iteractor{

    /**
     * method to load articles of the api
     * */
    override fun getArticles() {
        val api = MoblyApi()
        api.loadArticles()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe ({ articles ->
                    presenter.getArticles(articles)
                }, { e ->
                    e.printStackTrace()
                })
    }
}