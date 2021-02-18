package at.nacs.ex7insurancemessages.logic;

import at.nacs.ex7insurancemessages.logic.customer.CustomerLoader;
import at.nacs.ex7insurancemessages.logic.message.TemplateEngine;
import at.nacs.ex7insurancemessages.logic.sender.TextMessageSender;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
class CinemaMessageSenderTest {

    @Autowired
    CinemaMessageSender cinemaMessageSender;

    @MockBean
    CustomerLoader customerLoader;

    @MockBean
    TemplateEngine templateEngine;

    @SpyBean
    TextMessageSender textMessageSender;

    @Test
    void send() {
        when(customerLoader.getNames()).thenReturn(List.of("Mr. Simple Test"));
        when(templateEngine.getMessage(anyString())).thenReturn("Simple template");
        
        cinemaMessageSender.send();

        verify(textMessageSender, times(1)).send("Simple template");
    }
}