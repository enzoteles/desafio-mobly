package br.com.sdk.webservice.domain

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Delivery(

	@field:SerializedName("deliveredBy")
	val deliveredBy: Any? = null,

	@field:SerializedName("terms")
	val terms: Any? = null,

	@field:SerializedName("typeLabelLink")
	val typeLabelLink: String? = null,

	@field:SerializedName("details")
	val details: List<Any?>? = null,

	@field:SerializedName("time")
	val time: Time? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)