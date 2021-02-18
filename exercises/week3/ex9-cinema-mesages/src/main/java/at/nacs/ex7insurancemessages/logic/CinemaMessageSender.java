package at.nacs.ex7insurancemessages.logic;

import at.nacs.ex7insurancemessages.logic.customer.CustomerLoader;
import at.nacs.ex7insurancemessages.logic.message.TemplateEngine;
import at.nacs.ex7insurancemessages.logic.sender.TextMessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CinemaMessageSender {

    private final CustomerLoader customerLoader;
    private final TemplateEngine templateEngine;
    private final TextMessageSender textMessageSender;

    public void send() {
        customerLoader.getNames().stream()
                .map(templateEngine::getMessage)
                .forEach(textMessageSender::send);
    }

}
