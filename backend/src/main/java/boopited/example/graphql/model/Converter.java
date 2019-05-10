package boopited.example.graphql.model;

import boopited.example.graphql.error.GraphQLClientException;
import boopited.example.graphql.repo.CategoryRepo;

public class Converter {

    public static Password from(CategoryRepo categoryRepo, long id, InputEntry entry) {
        Category category = categoryRepo.findFirstById(entry.getCategoryId());
        return new Password((id > 0) ? id : generateId(), category, entry.getCategoryId(),
                entry.getType(), entry.getUserName(), entry.getPassword());
    }

    private static long generateId() {
        return System.currentTimeMillis();
    }

    public static Long parseLong(String id) throws GraphQLClientException {
        try {
            return Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new GraphQLClientException("ID invalid");
        }
    }
}
