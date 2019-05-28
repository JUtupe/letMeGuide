package com.github.fruitdrivendevelopers.letMeGuide.repository

import com.github.fruitdrivendevelopers.letMeGuide.entity.Attraction
import org.springframework.data.jpa.repository.JpaRepository

interface AttractionRepository: JpaRepository<Attraction, String>