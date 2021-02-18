package at.nacs.marathonserver.controller;

import at.nacs.marathonserver.persistence.Runner;
import at.nacs.marathonserver.util.TestRunners;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class RunnerEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    TestRunners testRunners;

    @Test
    void testAddRunner() {
        String url = "/runners";
        List<Runner> runners = getAsList(url);

        assertThat(runners).isEmpty();

        Runner runner = testRunners.getOne();
        Runner response = restTemplate.postForObject(url, runner, Runner.class);

        assertThat(response).isNotNull();
        assertThat(response).isEqualTo(runner);

        runners = getAsList(url);

        assertThat(runners).isNotEmpty();
        assertThat(runners).contains(runner);
    }

    private List<Runner> getAsList(String url) {
        Runner[] result = restTemplate.getForObject(url, Runner[].class);
        return List.of(result);
    }

}