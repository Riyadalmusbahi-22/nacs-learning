package at.nacs.ex7insurancemessages.logic.message.template;

import at.nacs.ex7insurancemessages.logic.message.template.DefaultTemplate;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DefaultTemplateTest {

    @Autowired
    DefaultTemplate defaultTemplate;

    @ParameterizedTest
    @ValueSource(strings = {"Mr. Yep", "Mrs. Yep", "Ms. Yep", "Yep"})
    void applySucceeds(String name) {
        Optional<String> message = defaultTemplate.apply(name);

        assertTrue(message.isPresent());
        assertEquals("Hi default " + name, message.get());
    }

}