package boopited.example.graphql.resolver;

import boopited.example.graphql.model.Category;
import boopited.example.graphql.model.Converter;
import boopited.example.graphql.model.Password;
import boopited.example.graphql.repo.CategoryRepo;
import boopited.example.graphql.repo.PasswordRepo;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class EntryQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private PasswordRepo passwordRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> listCategories() {
        return categoryRepo.findAll();
    }

    public List<Password> listEntries(long categoryId) {
        List<Password> passwords = passwordRepo.findAllByCategoryId(categoryId);
        return passwords != null ? passwords : Collections.emptyList();
    }

    public Password getEntry(String id) {
        return passwordRepo.findFirstById(Converter.parseLong(id));
    }
}
