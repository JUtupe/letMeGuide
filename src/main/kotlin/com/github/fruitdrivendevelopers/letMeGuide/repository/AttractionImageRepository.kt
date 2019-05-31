package com.github.fruitdrivendevelopers.letMeGuide.repository

import com.github.fruitdrivendevelopers.letMeGuide.entity.AttractionImage
import org.springframework.data.jpa.repository.JpaRepository

interface AttractionImageRepository: JpaRepository<AttractionImage, String>