package com.korea_travel.korea_travel_sns_project.config

import io.github.cdimascio.dotenv.dotenv
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.core.env.MapPropertySource

class DotenvApplicationContextInitializer  : ApplicationContextInitializer<ConfigurableApplicationContext> {

    override fun initialize(applicationContext: ConfigurableApplicationContext) {
        val dotenv = dotenv {
            directory = "./"
            ignoreIfMissing = true
        }

        // .env의 모든 변수를 Spring Environment에 추가
        val propertySource = MapPropertySource(
            "dotenv",
            dotenv.entries().associate { it.key to it.value }
        )

        // 가장 높은 우선순위로 추가
        applicationContext.environment.propertySources.addFirst(propertySource)
    }
}