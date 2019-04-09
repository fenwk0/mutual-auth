package com.macymoo.mutualauth;

import com.macymoo.mutualauth.domain.Greeting;
import com.macymoo.mutualauth.utils.RestApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MutualAuthApplicationTests {

    private RestApi restApi = new RestApi();

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.server.port}")
    private String serverPort;


    @LocalServerPort
    private int port;


    @Test
    public void contextLoads() {
        assertTrue("This will succeed.", true);
    }

    @Test
    public void testGreeting() {

        String testUrl = "http://localhost:" + port + "/greeting";
        String retVal = restApi.invoke(testUrl);
        System.out.println("MutualAuthApplicationTests.testGreeting");
        System.out.println("retVal = " + retVal);
    }

//    @Test
//    public void sayHi() {
//        RestTemplate restTemplate = new RestTemplate();
//        Greeting retVal = restTemplate.getForObject(testUrl, Greeting.class);
//        System.out.println("MutualAuthApplicationTests.sayHi");
//        System.out.println("retVal = " + retVal);
//    }

}
