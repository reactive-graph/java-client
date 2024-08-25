plugins {
    id("org.springframework.boot") version "3.3.3" apply false
    id("io.freefair.lombok") version "8.10"
}

allprojects {
    repositories {
        mavenCentral()
        maven {
            url = uri("https://repo.spring.io/libs-release")
        }
        mavenLocal()
    }
}
