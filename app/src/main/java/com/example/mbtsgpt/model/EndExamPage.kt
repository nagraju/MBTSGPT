package com.example.mbtsgpt.model

import com.google.gson.annotations.SerializedName

data class EndExamPage(val students: Students,
                       @SerializedName("marks")
                       val marks:List<Marks> )