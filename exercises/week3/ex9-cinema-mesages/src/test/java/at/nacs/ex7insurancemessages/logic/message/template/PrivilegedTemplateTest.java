package at.nacs.ex7insurancemessages.logic.message.template;

import at.nacs.ex7insurancemessages.logic.message.template.PrivilegedTemplate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PrivilegedTemplateTest {

    @Autowired
    PrivilegedTemplate privilegedTemplate;

    @ParameterizedTest
    @CsvSource({
            "true, Mr. Yep Testson",
            "true, Yep Testson",
            "false, Mister Nope"
    })
    void testIsValid(boolean expected, String name) {
        boolean actual = privilegedTemplate.isValid(name);

        assertEquals(expected, actual);
    }

    @Test
    void applySucceeds() {
        Optional<String> message = privilegedTemplate.apply("Mr. Delightful Testson");

        assertTrue(message.isPresent());
        assertEquals("Hi privileged Mr. Delightful Testson", message.get());
    }

    @Test
    void applyFails() {
        Optional<String> message = privilegedTemplate.apply("Delightful");

        assertTrue(message.isEmpty());
    }
}