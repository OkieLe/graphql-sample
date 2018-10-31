package boopited.example.graphql;

import boopited.example.graphql.config.GlobalProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GraphqlApplicationTests {

    @Autowired
    private GlobalProperties globalProperties;

    @Test
    public void getVersion() {
        String version = globalProperties.getAppVersion();
        Assert.assertEquals(version.substring(0, version.indexOf("-")), "0.0.1");
    }
}
