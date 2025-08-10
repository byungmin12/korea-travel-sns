package com.korea_travel.korea_travel_sns_project.controller

import com.korea_travel.korea_travel_sns_project.service.CrawlingGrowthcoreService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/gc")
class CrawlingGrowthcoreController(
    private val crawlService: CrawlingGrowthcoreService
) {
    @PostMapping("/ins/like/add")
    fun triggerCrawl(): ResponseEntity<String> {
        // 비동기로 실행하고 바로 202 Accepted 응답
        crawlService.addInstagramLike()
        return ResponseEntity
            .status(HttpStatus.ACCEPTED)
            .body("크롤링이 시작되었습니다.")
    }
}

