package io.reactive.graph.client.example;

import com.graphql_java_generator.client.GraphqlClientUtils;
import com.graphql_java_generator.client.graphqlrepository.EnableGraphQLRepositories;
import io.reactive.graph.EntityType;
import io.reactive.graph.util.QueryExecutor;
import io.reactive.graph.repository.EntityTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(
        scanBasePackageClasses = { ReactiveGraphClientExample.class, GraphqlClientUtils.class, QueryExecutor.class }
)
@EnableGraphQLRepositories({ "io.reactive.graph.repository" })
@Slf4j
public class ReactiveGraphClientExample {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveGraphClientExample.class, args);
    }

    @Autowired
    private EntityTypeRepository entityTypeRepository;

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            try {
                List<EntityType> entityTypes = entityTypeRepository.getAll().getTypes().getEntities();
                for (EntityType entityType : entityTypes) {
                    log.info("| {} | {} |", entityType.getNamespace(), entityType.getName());
                }
                SpringApplication.exit(ctx, new ExitCodeGenerator() {
                    @Override
                    public int getExitCode() {
                        return 0;
                    }
                });
            } catch (Exception e) {
                log.error("{}", e.getMessage(), e);
                SpringApplication.exit(ctx, new ExitCodeGenerator() {
                    @Override
                    public int getExitCode() {
                        return 1;
                    }
                });
            }
        };
    }

}
