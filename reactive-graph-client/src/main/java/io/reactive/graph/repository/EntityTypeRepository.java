package io.reactive.graph.repository;

import com.graphql_java_generator.annotation.RequestType;
import com.graphql_java_generator.client.graphqlrepository.FullRequest;
import com.graphql_java_generator.client.graphqlrepository.GraphQLRepository;
import com.graphql_java_generator.exception.GraphQLRequestExecutionException;
import io.reactive.graph.EntityType;
import io.reactive.graph.Query;
import io.reactive.graph.util.QueryExecutor;

import java.util.List;

@GraphQLRepository(queryExecutor = QueryExecutor.class)
public interface EntityTypeRepository {

    @FullRequest(request = "query { types { entities { }} }", requestType = RequestType.query)
    Query getAll() throws GraphQLRequestExecutionException;

}
