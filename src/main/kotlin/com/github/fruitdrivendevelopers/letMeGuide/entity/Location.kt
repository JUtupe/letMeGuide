package com.github.fruitdrivendevelopers.letMeGuide.entity

import javax.persistence.Embeddable

@Embeddable
class Location {
    lateinit var place: String
    var latitude: Long = -1
    var longitude: Long = -1
}