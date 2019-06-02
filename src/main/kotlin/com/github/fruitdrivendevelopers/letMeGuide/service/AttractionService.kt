package com.github.fruitdrivendevelopers.letMeGuide.service

import com.github.fruitdrivendevelopers.letMeGuide.entity.*
import com.github.fruitdrivendevelopers.letMeGuide.repository.AttractionDescriptionRepository
import com.github.fruitdrivendevelopers.letMeGuide.repository.AttractionImageRepository
import com.github.fruitdrivendevelopers.letMeGuide.repository.AttractionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AttractionService @Autowired constructor(
        private val attractionRepository: AttractionRepository,
        private val attractionDescriptionRepository: AttractionDescriptionRepository,
        private val attractionImageRepository: AttractionImageRepository) {

    fun getAttractions(): MutableList<Attraction> {
        return attractionRepository.findAll()
    }

    fun getAttraction(id: String): Attraction =
            attractionRepository.findByIdOrNull(id) ?: TODO("throw here")

    fun createAttraction(request: CreateAttractionRequest): Attraction {
        val attraction = Attraction().apply {
            location = Location().apply {
                place = request.place
                latitude = request.latitude
                longitude = request.longitude
                pageUrl = request.pageUrl
            }
        }

        return attractionRepository.save(attraction)
    }

    fun addDescription(id: String, request: CreateAttractionDescriptionRequest): Attraction {
        val attraction = attractionRepository.findByIdOrNull(id) ?: TODO("throw here")

        var description = AttractionDescription().apply {
            language = request.language
            description = request.description
            history = request.history
            author = request.author
            name = request.name
        }

        description = attractionDescriptionRepository.save(description)

        attraction.descriptions.add(description)

        return attractionRepository.save(attraction)
    }

    fun deleteAttraction(id: String) {
        val attraction = attractionRepository.findByIdOrNull(id) ?: TODO("throw here")

        attraction.descriptions.forEach {
            attractionDescriptionRepository.delete(it)
        }

        attractionRepository.delete(attraction)
    }

    fun addImage(id: String, imagePath: String) {
        val attraction = attractionRepository.findByIdOrNull(id) ?: TODO("throw here")

        var image = AttractionImage().apply {
            this.imagePath = imagePath
        }

        image = attractionImageRepository.save(image)
        attraction.images.add(image)
        attractionRepository.save(attraction)
    }

    fun deleteImage(id: String, imageId: String) {
        val attraction = attractionRepository.findByIdOrNull(id) ?: TODO("throw here")
        val image = attractionImageRepository.findByIdOrNull(imageId) ?: TODO("throw here")

        attraction.images.remove(image)

        attractionImageRepository.delete(image)
        attractionRepository.save(attraction)
    }

    fun deleteDescription(id: String) {
        val description = attractionDescriptionRepository.findByIdOrNull(id) ?: TODO("throw here")

        attractionDescriptionRepository.delete(description)
    }
}