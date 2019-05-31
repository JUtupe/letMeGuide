package com.github.fruitdrivendevelopers.letMeGuide.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "descriptions")
class AttractionDescription {
    @Id
    @Column(length = 190)
    var id: String = UUID.randomUUID().toString()
    var language: Language? = null
    var name: String? = null
    @Column(length = 3000)
    var description: String? = null
    @Column(length = 3000)
    var history: String? = null
    var author: String? = null
}