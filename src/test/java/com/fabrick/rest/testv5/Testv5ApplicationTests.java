package com.fabrick.rest.testv5;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application.properties")
@SpringBootTest
class Testv5ApplicationTests {

    @Test
    void contextLoads() {
        Assert.assertTrue(true);
    }

    @Test
    void mainMethod() {
        String[] args = new String[0];
        Testv5Application.main(args);
        Assert.assertTrue(true);
    }
}
