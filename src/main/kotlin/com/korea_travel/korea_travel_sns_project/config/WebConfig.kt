package com.korea_travel.korea_travel_sns_project.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {

    override fun addViewControllers(registry: ViewControllerRegistry) {
        // "/" 요청은 actuator/health로 내부 forward
        registry.addViewController("/").setViewName("forward:/actuator/health")
    }
}