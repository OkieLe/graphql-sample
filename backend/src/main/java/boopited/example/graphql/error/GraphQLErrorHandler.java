package boopited.example.graphql.error;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.DefaultGraphQLErrorHandler;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class GraphQLErrorHandler extends DefaultGraphQLErrorHandler {

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> errors) {
        return super.processErrors(errors);
    }

    @Override
    protected List<GraphQLError> filterGraphQLErrors(List<GraphQLError> errors) {
        return errors.stream()
                .filter(e -> e instanceof ExceptionWhileDataFetching || super.isClientError(e))
                .map(this::wrapperGraphQLError)
                .collect(Collectors.toList());
    }

    protected GraphQLError wrapperGraphQLError(GraphQLError error) {
        return new GraphQLClientException("");
    }
}
