package br.com.sdk.webservice.service

import br.com.sdk.webservice.domain.JsonArticles
import io.reactivex.Observable
import retrofit2.http.GET

interface MoblyApiRest {

    @GET("v2.0/categories/100/articles?appDomain=1&locale=de_DE&limit=10")
    fun artitles(): Observable<JsonArticles>

/*    @GET("v1/articles/{href}")
    fun details(@Path("href") href: String?): Observable<JsonResponseDetails>*/
}