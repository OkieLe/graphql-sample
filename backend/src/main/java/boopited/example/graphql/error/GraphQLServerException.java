package boopited.example.graphql.error;

import com.fasterxml.jackson.annotation.JsonIgnore;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;
import java.util.Map;

public class GraphQLServerException extends RuntimeException implements GraphQLError {

    public GraphQLServerException(String message) {
        super(message);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return null;
    }

    @Override
    @JsonIgnore
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }
}
