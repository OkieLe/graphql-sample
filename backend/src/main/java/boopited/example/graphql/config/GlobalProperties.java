package boopited.example.graphql.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class GlobalProperties {

    @Value("${build.version.running}")
    public String appVersion;
}
