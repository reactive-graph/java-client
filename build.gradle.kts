plugins {
    id("org.springframework.boot") version "3.3.3" apply false
    id("io.freefair.lombok") version "8.10"
    id("com.graphql-java-generator.graphql-gradle-plugin3") version "2.7" apply false
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
