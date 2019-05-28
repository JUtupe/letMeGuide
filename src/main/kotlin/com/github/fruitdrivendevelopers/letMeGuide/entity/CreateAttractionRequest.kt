package com.github.fruitdrivendevelopers.letMeGuide.entity

data class CreateAttractionRequest(
        var place: String,
        var latitude: Long,
        var longitude: Long
)