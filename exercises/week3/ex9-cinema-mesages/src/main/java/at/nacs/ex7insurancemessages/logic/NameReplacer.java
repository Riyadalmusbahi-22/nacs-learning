package at.nacs.ex7insurancemessages.logic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NameReplacer {

    @Value("${template.replacer}")
    private String replacer;

    public String replace(String message, String name) {
        return message.replace(replacer, name);
    }

}
