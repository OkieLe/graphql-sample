package boopited.example.graphql.repo;

import boopited.example.graphql.model.InputEntry;
import boopited.example.graphql.model.Password;

public interface PasswordRepoCustom {

    Password addPassword(InputEntry entry);

    long updatePassword(long id, InputEntry entry);

    boolean deletePassword(long id);
}
