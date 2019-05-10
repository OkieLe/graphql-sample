package boopited.example.graphql.resolver;

import boopited.example.graphql.model.Converter;
import boopited.example.graphql.model.InputEntry;
import boopited.example.graphql.model.Password;
import boopited.example.graphql.repo.PasswordRepo;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntryEditResolver implements GraphQLMutationResolver {

    @Autowired
    private PasswordRepo passwordRepo;

    public Password addEntry(InputEntry entry) {
        return passwordRepo.addPassword(entry);
    }

    public long updateEntry(String id, InputEntry entry) {
        return passwordRepo.updatePassword(Converter.parseLong(id), entry);
    }

    public boolean removeEntry(String id) {
        passwordRepo.deletePassword(Converter.parseLong(id));
        return true;
    }
}
