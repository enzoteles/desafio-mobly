package br.com.sdk.webservice.domain

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class MediaItem(

	@field:SerializedName("size")
	val size: Any? = null,

	@field:SerializedName("mimeType")
	val mimeType: String? = null,

	@field:SerializedName("type")
	val type: Any? = null,

	@field:SerializedName("priority")
	val priority: Int? = null,

	@field:SerializedName("uri")
	val uri: String? = null
)