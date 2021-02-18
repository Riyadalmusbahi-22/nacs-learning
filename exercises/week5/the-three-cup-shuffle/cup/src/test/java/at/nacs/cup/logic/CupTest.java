package at.nacs.cup.logic;

import at.nacs.cup.logic.Cup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class CupTest {

    @Autowired
    Cup cup;

    @BeforeEach
    void setup() {
        cup.removeCoin();
    }

    @Test
    void hasCoin() {
        assertThat(cup.hasCoin()).isFalse();
    }

    @Test
    void placeCoin() {
        assertThat(cup.hasCoin()).isFalse();

        cup.placeCoin();

        assertThat(cup.hasCoin()).isTrue();
    }

    @Test
    void removeCoin() {
        cup.placeCoin();
        assertThat(cup.hasCoin()).isTrue();

        cup.removeCoin();

        assertThat(cup.hasCoin()).isFalse();
    }
}