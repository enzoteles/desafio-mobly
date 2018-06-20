package br.com.sdk.webservice.domain

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ValuesItem(

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("priority")
	val priority: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("_metadata")
	val metadata: Metadata? = null
)