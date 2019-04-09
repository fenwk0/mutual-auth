package com.macymoo.mutualauth;

import com.macymoo.mutualauth.utils.RestApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MutualAuthApplicationTests {

    private RestApi restApi = new RestApi();

    @LocalServerPort
    private int port;


    @Test
    public void contextLoads() {
        assertTrue("This will succeed.", true);
    }

    @Test
    public void testGreeting() {
        String testUrl = "https://localhost:" + port + "/greeting";
        try {
            System.out.println("MutualAuthApplicationTests.testGreeting: " + testUrl);
            String retVal = restApi.invoke(testUrl);
            System.out.println("retVal = " + retVal);
            assertTrue(retVal.contains("Success: [200]\n" +
                    "{\"id\":1,\"content\":\"[greeting][0] Hello, World!\"}"));

        } catch (Exception e) {
            fail(e.getMessage() + testUrl);
        }
    }

}
