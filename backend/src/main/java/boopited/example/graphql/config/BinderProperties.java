package boopited.example.graphql.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "prop.binder")
public class BinderProperties {

    private String who;

    private String where;

    private String when;
}
