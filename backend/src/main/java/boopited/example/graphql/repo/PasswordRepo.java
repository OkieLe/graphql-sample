package boopited.example.graphql.repo;

import boopited.example.graphql.model.Password;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PasswordRepo extends MongoRepository<Password, Long>, PasswordRepoCustom {

    Password findFirstById(long id);

    List<Password> findAllByCategoryId(long id);
}
