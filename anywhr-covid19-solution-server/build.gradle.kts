import org.gradle.api.tasks.testing.logging.TestExceptionFormat

group = "co.anywhr"

extra["spring.version"] = "5.2.3.RELEASE"
extra["spring.boot.version"] = "2.2.4.RELEASE"
extra["spring.cloud.version"] = "Hoxton.SR2"

plugins {
    java
    idea
    id("org.springframework.boot") version "2.2.4.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
    jacoco
    id("org.sonarqube") version "2.6.2"
    id("io.franzbecker.gradle-lombok") version "3.1.0"
}

repositories {
    jcenter()
    maven("https://repo.spring.io/milestone")
    maven("https://dl.bintray.com/americanexpress/maven/")
}

dependencies {
    implementation("io.aexp.nodes.graphql:nodes:0.4.0")
    implementation(enforcedPlatform("org.springframework.cloud:spring-cloud-dependencies:${extra["spring.cloud.version"]}"))
    implementation("javax.inject:javax.inject:1")
    implementation("com.google.guava:guava:26.0-jre")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    implementation("io.springfox:springfox-swagger2:2.9.2")
    implementation("io.springfox:springfox-swagger-ui:2.9.2")

    implementation("org.springframework.cloud:spring-cloud-starter-sleuth")

    implementation("org.flywaydb:flyway-core")
    implementation("org.postgresql:postgresql")

    compile("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    compile("org.mapstruct:mapstruct:1.3.0.Final")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.3.0.Final")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "junit")
    }

    compileOnly("uk.co.jemos.podam:podam:7.2.1.RELEASE")
    compileOnly("com.github.javafaker:javafaker:0.17.2")

    testImplementation("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("com.github.tomakehurst:wiremock-jre8:2.21.0")
    testImplementation("com.h2database:h2")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("uk.co.jemos.podam:podam:7.2.1.RELEASE")
    testImplementation("com.github.javafaker:javafaker:0.17.2")
}

tasks {
    
    compileJava {
        options.compilerArgs.addAll(listOf(
                "-Amapstruct.defaultComponentModel=jsr330"
        ))
    }

    test {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
            showExceptions = true
            showCauses = true
            exceptionFormat = TestExceptionFormat.FULL
        }
    }
}
