package boopited.example.graphql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "category")
public class Category {

    @Id
    @JsonProperty("id")
    private long id;

    @JsonProperty("category")
    private String category;
}
