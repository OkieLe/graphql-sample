package boopited.example.graphql.repo;

import boopited.example.graphql.model.Converter;
import boopited.example.graphql.model.InputEntry;
import boopited.example.graphql.model.Password;
import org.springframework.beans.factory.annotation.Autowired;

public class PasswordRepoImpl implements PasswordRepoCustom {

    @Autowired
    private PasswordRepo passwordRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Password addPassword(InputEntry entry) {
        return passwordRepo.insert(Converter.from(categoryRepo, 0, entry));
    }

    @Override
    public long updatePassword(long id, InputEntry entry) {
        return passwordRepo.save(Converter.from(categoryRepo, id, entry)).getId();
    }

    @Override
    public boolean deletePassword(long id) {
        try {
            passwordRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
