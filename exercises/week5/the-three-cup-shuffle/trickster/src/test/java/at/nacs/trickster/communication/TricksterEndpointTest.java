package at.nacs.trickster.communication;

import at.nacs.trickster.logic.Trickster;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class TricksterEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    Trickster trickster;

    @Test
    void play() {
        String url = "/play";

        String actual = restTemplate.getForObject(url, String.class);

        assertThat(actual).isEqualTo("The game has started!");
        verify(trickster).startGame();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void choose(int choice) {
        String url = "/choose/" + choice;
        boolean expected = true;
        when(trickster.choose(choice)).thenReturn(expected);

        boolean actual = restTemplate.getForObject(url, Boolean.class);

        assertThat(actual).isEqualTo(expected);
        verify(trickster).choose(choice);
    }
}