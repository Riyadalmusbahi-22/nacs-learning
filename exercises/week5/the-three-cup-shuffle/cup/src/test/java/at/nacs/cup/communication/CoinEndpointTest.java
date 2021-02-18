package at.nacs.cup.communication;

import at.nacs.cup.logic.Cup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class CoinEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @SpyBean
    Cup cup;

    String url = "/coin";

    @BeforeEach
    void setup() {
        cup.removeCoin();
    }

    @Test
    void get() {
        Boolean response = restTemplate.getForObject(url, Boolean.class);

        assertThat(response).isFalse();
        verify(cup).hasCoin();
    }

    @Test
    void put() {
        restTemplate.put(url, null);

        Boolean response = restTemplate.getForObject(url, Boolean.class);
        assertThat(response).isTrue();
        verify(cup).placeCoin();
    }

    @Test
    void delete() {
        restTemplate.put(url, null);

        Boolean response = restTemplate.getForObject(url, Boolean.class);
        assertThat(response).isTrue();

        restTemplate.delete(url);

        response = restTemplate.getForObject(url, Boolean.class);
        assertThat(response).isFalse();
        verify(cup, atLeast(1)).removeCoin();
    }
}