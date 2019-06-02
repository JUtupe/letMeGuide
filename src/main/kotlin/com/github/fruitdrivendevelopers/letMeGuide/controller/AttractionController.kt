package com.github.fruitdrivendevelopers.letMeGuide.controller

import com.github.fruitdrivendevelopers.letMeGuide.entity.CreateAttractionDescriptionRequest
import com.github.fruitdrivendevelopers.letMeGuide.entity.CreateAttractionRequest
import com.github.fruitdrivendevelopers.letMeGuide.service.AttractionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/")
class AttractionController @Autowired constructor(private val attractionService: AttractionService) {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("attraction")
    fun getAttractions() = attractionService.getAttractions()

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("attraction/{id}")
    fun getAttraction(@PathVariable("id") id: String) = attractionService.getAttraction(id)

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("attraction")
    fun createAttraction(@RequestBody @Valid request: CreateAttractionRequest) =
            attractionService.createAttraction(request)

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("attraction/{id}/description")
    fun addDescription(@PathVariable("id") id: String,
                       @RequestBody @Valid request: CreateAttractionDescriptionRequest) =
            attractionService.addDescription(id, request)

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("attraction/{id}/description")
    fun deleteDescription(@PathVariable("id") id: String) =
            attractionService.deleteDescription(id)

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("attraction/{id}")
    fun deleteAttraction(@PathVariable("id") id: String) =
            attractionService.deleteAttraction(id)

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("attraction/{id}/image")
    fun addImage(@PathVariable("id") id: String, @RequestBody imagePath: String) =
            attractionService.addImage(id, imagePath)

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("attraction/{id}/image/{imageId}")
    fun deleteImage(@PathVariable("id") id: String, @PathVariable("imageId") imageId: String) =
            attractionService.deleteImage(id, imageId)
}