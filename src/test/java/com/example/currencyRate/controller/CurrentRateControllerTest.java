package com.example.currencyRate.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CurrentRateControllerTest {

    @LocalServerPort
    int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void imgShouldBeReturned() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/RUB", String.class)).contains("<img src=\"https");
    }

    @Test
    public void mainShouldBeReturned() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class)).contains("<img src=\"https");
    }
}
