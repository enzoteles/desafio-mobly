package br.com.sdk.webservice.service

import br.com.sdk.webservice.domain.JsonArticles
import io.reactivex.Observable

class MoblyApi : BaseApi(){

    fun loadArticles(): Observable<JsonArticles>? {
        return service.artitles()
    }

}