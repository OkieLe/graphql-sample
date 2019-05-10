package boopited.example.graphql.repo;

import boopited.example.graphql.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepo extends MongoRepository<Category, Long> {

    Category findFirstById(long id);
}
