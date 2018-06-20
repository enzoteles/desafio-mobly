package br.com.sdk.webservice.domain

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class JsonArticles(

	@field:SerializedName("_links")
	val links: Links? = null,

	@field:SerializedName("_embedded")
	val embedded: Embedded? = null,

	@field:SerializedName("articlesCount")
	val articlesCount: Int? = null
)