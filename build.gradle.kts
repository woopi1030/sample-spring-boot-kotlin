plugins {
	kotlin("jvm") version "1.9.25" 
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.3.3" 
	id("io.spring.dependency-management") version "1.1.6"
}

allprojects {
    group = "com.woopi"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}


java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    tasks.withType<JavaCompile> {
        sourceCompatibility = JavaVersion.VERSION_21.toString()
        targetCompatibility = JavaVersion.VERSION_21.toString()
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib")
		testImplementation("org.springframework.boot:spring-boot-starter-test")
    }
}

// Disable the bootJar task
tasks.named<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    enabled = false
}

// Ensure that the jar task is enabled
tasks.named<Jar>("jar") {
    enabled = true
}


// 빌드 시 mainclass 문제 해결방법 : https://stackoverflow.com/questions/56861256/gradle-build-failed-main-class-name-has-not-been-configured-and-it-could-not-be
// final class 해결 방법 https://velog.io/@kdohyeon/may-not-be-final-%ED%95%B4%EA%B2%B0%ED%95%98%EA%B8%B0