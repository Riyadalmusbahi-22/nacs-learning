package at.nacs.ex7insurancemessages.logic.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NamesTest {

    @ParameterizedTest
    @CsvSource({
            "Mr., Mr. Hey",
            "Mrs., Mrs. Yo",
            "Ms., Ms. Waw",
            "Smartmanta, Smartmanta",
    })
    void getTitle(String expected, String name) {
        String actual = Names.getTitle(name);

        assertEquals(expected, actual);
    }
}