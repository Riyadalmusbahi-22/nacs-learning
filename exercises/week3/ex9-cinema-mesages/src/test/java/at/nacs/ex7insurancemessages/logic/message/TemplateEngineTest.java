package at.nacs.ex7insurancemessages.logic.message;

import at.nacs.ex7insurancemessages.logic.sender.TextMessageSender;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TemplateEngineTest {

    @Autowired
    TemplateEngine engine;

    @SpyBean
    TextMessageSender sender;

    @ParameterizedTest
    @CsvSource({
            "Hi man Mr. Yep, Mr. Yep",
            "Hi woman Mrs. Yep, Mrs. Yep",
            "Hi woman Ms. Yep, Ms. Yep",
            "Hi privileged Yep Testson, Yep Testson",
            "Hi default Yep, Yep",
    })
    void getMessageSucceeds(String expected, String name) {
        String actual = engine.getMessage(name);

        assertEquals(expected, actual);
    }
}