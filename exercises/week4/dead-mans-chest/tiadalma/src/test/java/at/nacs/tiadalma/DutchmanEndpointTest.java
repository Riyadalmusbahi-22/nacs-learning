package at.nacs.tiadalma;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class DutchmanEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Value("${dutchman.url}")
    String dutchmanUrl;

    String url = "/dutchman";

    @Test
    void get() {
        String response = restTemplate.getForObject(url, String.class);

        assertThat(response).isEqualTo(dutchmanUrl);
    }
}