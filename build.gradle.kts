plugins {
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
    kotlin("plugin.jpa") version "1.9.22"
}

group = "com.korea-travel"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // ✅ [1] Spring 핵심
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    implementation("org.springframework.boot:spring-boot-starter-security") // JWT 인증 // TODO 나중에 추가

    // ✅ [2] Kotlin 필수
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // ✅ [3] DB
    runtimeOnly("com.mysql:mysql-connector-j") // 또는 H2
    // runtimeOnly("com.h2database:h2") // 테스트용 인메모리 DB

    // ✅ [4] JWT 인증
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")

    // ✅ [5] 크롤링 (Selenium + WebDriverManager)
    implementation("org.seleniumhq.selenium:selenium-java:4.21.0")
    implementation("io.github.bonigarcia:webdrivermanager:5.8.0")

    // ✅ [6] API 문서화
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")

    // ✅ [7] 개발 편의
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")

    // ✅ [7] 테스트
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.9.22")

}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
