package boopited.example.graphql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputEntry {

    @JsonProperty("categoryId")
    private long categoryId;

    @JsonProperty("type")
    private String type;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("password")
    private String password;
}
