package at.nacs.ex7insurancemessages.logic.sender;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TextMessageSenderTest {

    @Autowired
    TextMessageSender sender;

    @Test
    void buildMessage() {
        String actual = sender.buildMessage("hello");

        String expected = "Message sent: hello";
        assertEquals(expected, actual);
    }
}