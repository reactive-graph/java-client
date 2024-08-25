plugins {
    java
    id("org.springframework.boot")
    id("io.freefair.lombok")
}

apply(plugin = "io.spring.dependency-management")

group = "io.reactive.graph.client"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("com.graphql-java-generator:graphql-java-client-runtime:2.7")
    implementation(project(":reactive-graph-client"))

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

springBoot {
    mainClass.set("io.reactive.graph.client.example.ReactiveGraphClientExample")
}
