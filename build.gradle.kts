import org.gradle.api.tasks.wrapper.Wrapper

plugins {
    java
    id("org.springframework.boot") version "1.5.2.RELEASE"
    id("io.spring.dependency-management") version "1.0.2.RELEASE"
}
group = "org.jlleitschuh.boot-test"
version = "1.0-SNAPSHOT"

configurations.all {
    resolutionStrategy {
        // I explicitly set the version of logback classic that I want here, but it is ignored 😢
        force("ch.qos.logback:logback-classic:1.1.3")
    }
}

dependencies {
    compile(group = "org.springframework.boot", name = "spring-boot-starter-security")
    compile(group = "org.springframework.boot", name = "spring-boot-starter-tomcat")
}

repositories {
    mavenCentral()
}

springBoot {
    mainClass = "Application"
}


task<Wrapper>("wrapper") {
    distributionUrl = "https://repo.gradle.org/gradle/dist-snapshots/gradle-script-kotlin-3.5-20170404014535+0000-all.zip"
    distributionType = Wrapper.DistributionType.ALL
}

/**
 * Retrieves or configures the [springBoot][org.springframework.boot.gradle.SpringBootPluginExtension] project extension.
 */
fun Project.springBoot(configure: org.springframework.boot.gradle.SpringBootPluginExtension.() -> Unit = {}) =
    extensions.getByName<org.springframework.boot.gradle.SpringBootPluginExtension>("springBoot").apply { configure() }
