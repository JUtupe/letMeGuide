package com.github.fruitdrivendevelopers.letMeGuide.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "images")
class AttractionImage {
    @Id
    @Column(length = 190)
    var id: String = UUID.randomUUID().toString()

    @Column
    lateinit var imagePath: String
}