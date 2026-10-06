package com.propertyinspection;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class HealthEndpointSteps {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<Map> response;

    @Given("the application has started")
    void applicationHasStarted() {
        assertThat(applicationContext.isActive()).isTrue();
    }

    @When("I request the application health status")
    void requestApplicationHealthStatus() {
        response = restTemplate.getForEntity("/actuator/health", Map.class);
    }

    @Then("the response status is {int}")
    void responseStatusIs(int expectedStatus) {
        assertThat(response.getStatusCode().value()).isEqualTo(expectedStatus);
    }

    @Then("the response body reports the status {string}")
    void responseBodyReportsStatus(String expectedStatus) {
        assertThat(response.getBody())
                .isNotNull()
                .containsEntry("status", expectedStatus);
    }
}
