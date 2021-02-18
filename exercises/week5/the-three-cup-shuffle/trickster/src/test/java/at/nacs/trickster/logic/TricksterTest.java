package at.nacs.trickster.logic;

import at.nacs.trickster.communication.CupClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class TricksterTest {

    @Autowired
    Trickster trickster;

    @MockBean
    CupClient cupClient;

    @Value("${cup.number-of-cups}")
    int numberOfCups;

    @Test
    void startGame() {
        trickster.startGame();

        verify(cupClient, times(numberOfCups)).delete(anyInt());
        verify(cupClient).put(anyInt());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void choose(int choice) {
        boolean expected = true;

        when(cupClient.get(choice)).thenReturn(expected);

        boolean actual = trickster.choose(choice);

        assertThat(actual).isEqualTo(expected);
        verify(cupClient).get(choice);
    }
}