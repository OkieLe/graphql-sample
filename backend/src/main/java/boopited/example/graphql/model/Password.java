package boopited.example.graphql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "password")
public class Password {

    @Id
    @JsonProperty("id")
    private long id;

    @JsonProperty("category")
    private Category category;

    @JsonIgnore
    private long categoryId;

    @JsonProperty("type")
    private String type;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("password")
    private String password;
}
