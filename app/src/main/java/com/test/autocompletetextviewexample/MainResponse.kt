package com.test.autocompletetextviewexample

import com.google.gson.annotations.SerializedName

data class MainResponse(

    @SerializedName("total_count") val total_count : Int,
    @SerializedName("incomplete_results") val incomplete_results : Boolean,
    @SerializedName("items") val items : ArrayList<User>
)