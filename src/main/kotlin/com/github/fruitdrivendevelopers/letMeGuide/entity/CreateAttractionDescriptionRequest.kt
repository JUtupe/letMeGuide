package com.github.fruitdrivendevelopers.letMeGuide.entity

data class CreateAttractionDescriptionRequest(
    val language: Language,
    var name: String,
    var description: String,
    var history: String,
    var author: String
)