package at.nacs.ex7insurancemessages.logic.message.template;

import at.nacs.ex7insurancemessages.logic.message.template.ManTemplate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ManTemplateTest {

    @Autowired
    ManTemplate manTemplate;

    @ParameterizedTest
    @CsvSource({
            "true, Mr. Yep",
            "false, Mister Nope"
    })
    void testIsValid(boolean expected, String name) {
        boolean actual = manTemplate.isValid(name);

        assertEquals(expected, actual);
    }

    @Test
    void applySucceeds() {
        Optional<String> message = manTemplate.apply("Mr. Delightful");

        assertTrue(message.isPresent());
        assertEquals("Hi man Mr. Delightful", message.get());
    }

    @Test
    void applyFails() {
        Optional<String> message = manTemplate.apply("Delightful");

        assertTrue(message.isEmpty());
    }
}