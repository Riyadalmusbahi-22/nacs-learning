package at.nacs.polo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PoloEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    String url = "/polo";

    @ParameterizedTest
    @CsvSource({
            "Polo, Marco",
            "What?, marco",
            "What?, Polo",
            "What?, polo",
            "What?, basically anything else"
    })
    void post(String expected, String message) {
        String actual = restTemplate.postForObject(url, message, String.class);

        assertThat(actual).isEqualTo(expected);
    }
}