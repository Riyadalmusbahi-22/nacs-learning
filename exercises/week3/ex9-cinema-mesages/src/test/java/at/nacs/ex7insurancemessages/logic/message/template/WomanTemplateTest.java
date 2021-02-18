package at.nacs.ex7insurancemessages.logic.message.template;

import at.nacs.ex7insurancemessages.logic.message.template.WomanTemplate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class WomanTemplateTest {

    @Autowired
    WomanTemplate womanTemplate;

    @ParameterizedTest
    @CsvSource({
            "true, Mrs. Yep",
            "true, Ms. Yep",
            "false, Miss Nope"
    })
    void testIsValid(boolean expected, String name) {
        boolean actual = womanTemplate.isValid(name);

        assertEquals(expected, actual);
    }

    @Test
    void applySucceeds() {
        Optional<String> message = womanTemplate.apply("Mrs. Delightful");

        assertTrue(message.isPresent());
        assertEquals("Hi woman Mrs. Delightful", message.get());
    }

    @Test
    void applyFails() {
        Optional<String> message = womanTemplate.apply("Delightful");

        assertTrue(message.isEmpty());
    }
}