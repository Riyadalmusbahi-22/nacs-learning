package at.nacs.ex7insurancemessages.logic.message.template;

import at.nacs.ex7insurancemessages.logic.NameReplacer;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@ConfigurationProperties("template.default")
public class DefaultTemplate implements Template {

    private final NameReplacer replacer;

    @Setter
    private String message;

    @Override
    public Optional<String> apply(String name) {
        return Optional.of(replacer.replace(message, name));
    }

}
