package br.com.sdk.webservice.domain

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Price(

	@field:SerializedName("amount")
	val amount: String? = null,

	@field:SerializedName("recommendedRetailPrice")
	val recommendedRetailPrice: Boolean? = null,

	@field:SerializedName("currency")
	val currency: String? = null
)