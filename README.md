# Reactive Graph - Java Client

> Note: This is work in progress and not yet useful!

## About

This repository contains a client written in Java to access the reactive graph.

The main goal for now is to show that it's possible to use the reactive graph from a non-rust application. Actually,
the first working java client has been realized within an evening.

## How it works

* A gradle plugin generates POJOs / interfaces for each type in the GraphQL schema.
* Spring Data alike repositories can be defined to build queries and mutations on top of the generated POJOs / interfaces.
* Your application uses the POJOs / interfaces and spring data alike repositories. An example is provided in the `example` module.

## Configuration

In `application.properties`, point the `graphql.endpoint.url` to a running instance of reactive-graph:

```properties
graphql.endpoint.url=http://localhost:31415/graphql
```

## Example

The example provides a spring boot application that uses the `EntityTypeRepository` to fetch all `EntityType`s.

## Build

```shell
sdk env # or sdk env install (if you run it the first time)
./gradlew build
```

## Schema to POJO

* https://plugins.gradle.org/plugin/com.graphql-java-generator.graphql-gradle-plugin3
* https://graphql-maven-plugin-project.graphql-java-generator.com/graphql-maven-plugin/project-info.html
* https://github.com/graphql-java-generator/graphql-maven-plugin-project/wiki/client_graphql_repository
* 


## Future

The future plan is to provide the same amount of support for the java client as for the rust client.

### Why Java?

1. Java provides a huge ecosystem:
    * Neo4j (as graph database) - as source or as target
    * Apache kafka - as producer or as consumer
    * Elasticsearch - for indexing and searching
    * ...
2. Write your application in your language

