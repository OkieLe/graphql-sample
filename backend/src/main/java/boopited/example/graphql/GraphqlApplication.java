package boopited.example.graphql;

import boopited.example.graphql.config.BinderProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GraphqlApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(GraphqlApplication.class, args);

        Binder binder = Binder.get(context.getEnvironment());
        binder.bind("prop.binder", Bindable.of(BinderProperties.class));
    }
}
