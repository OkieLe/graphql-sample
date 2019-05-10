package boopited.example.graphql;

import boopited.example.graphql.config.GlobalProperties;
import boopited.example.graphql.model.Category;
import boopited.example.graphql.repo.CategoryRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class GraphqlApplication {

    @Autowired
    private GlobalProperties globalProperties;

    @Autowired
    private CategoryRepo categoryRepo;

    public static void main(String[] args) {
        SpringApplication.run(GraphqlApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner() {
        return args -> {
            String data = globalProperties.initData;
            if (!data.isEmpty()) {
                ObjectMapper mapper = new ObjectMapper();
                TypeReference<List<Category>> typeReference = new TypeReference<List<Category>>(){};
                InputStream inputStream = TypeReference.class.getResourceAsStream(data);
                try {
                    List<Category> categories = mapper.readValue(inputStream, typeReference);
                    categoryRepo.saveAll(categories);
                    System.out.println("Categories saved " + categories.size());
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        };
    }
}
