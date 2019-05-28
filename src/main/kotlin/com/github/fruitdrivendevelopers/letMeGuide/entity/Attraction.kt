package com.github.fruitdrivendevelopers.letMeGuide.entity

import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "attractions")
class Attraction {
    @Id
    @Column(length = 190)
    var id: String = UUID.randomUUID().toString()

    @CreationTimestamp
    var creationDate: Date = Date()

    @OneToMany(targetEntity = AttractionDescription::class)
    var descriptions: MutableList<AttractionDescription> = mutableListOf()

    @Embedded
    var location: Location? = null
}