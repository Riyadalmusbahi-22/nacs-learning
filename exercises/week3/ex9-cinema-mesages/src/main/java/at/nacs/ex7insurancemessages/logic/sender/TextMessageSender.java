package at.nacs.ex7insurancemessages.logic.sender;

import org.springframework.stereotype.Component;

@Component
public class TextMessageSender {

    public void send(String message) {
        System.out.println(buildMessage(message));
    }

    String buildMessage(String message) {
        return "Message sent: " + message;
    }

}
