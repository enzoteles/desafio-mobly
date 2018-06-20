package br.com.sdk.webservice.domain

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class FiltersItem(

	@field:SerializedName("min")
	val min: Int? = null,

	@field:SerializedName("max")
	val max: Int? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("priority")
	val priority: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("currentMax")
	val currentMax: Int? = null,

	@field:SerializedName("_metadata")
	val metadata: Metadata? = null,

	@field:SerializedName("currentMin")
	val currentMin: Int? = null,

	@field:SerializedName("values")
	val values: List<ValuesItem?>? = null
)