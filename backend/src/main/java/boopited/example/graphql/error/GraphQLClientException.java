package boopited.example.graphql.error;

import com.fasterxml.jackson.annotation.JsonIgnore;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;

public class GraphQLClientException extends RuntimeException implements GraphQLError {

    public GraphQLClientException(String message) {
        super(message);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.InvalidSyntax;
    }

    @Override
    @JsonIgnore
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }
}
