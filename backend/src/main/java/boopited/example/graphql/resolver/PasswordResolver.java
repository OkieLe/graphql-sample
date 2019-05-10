package boopited.example.graphql.resolver;

import boopited.example.graphql.model.Category;
import boopited.example.graphql.model.Password;
import boopited.example.graphql.repo.CategoryRepo;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PasswordResolver implements GraphQLResolver<Password> {

    @Autowired
    private CategoryRepo categoryRepo;

    public Category getCategory(Password entry) {
        return categoryRepo.findFirstById(entry.getCategoryId());
    }
}
