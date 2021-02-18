package at.nacs.ex7insurancemessages.logic.message.template;

import at.nacs.ex7insurancemessages.logic.NameReplacer;
import at.nacs.ex7insurancemessages.logic.util.Names;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@ConfigurationProperties("template.man")
public class ManTemplate implements Template {

    private final NameReplacer replacer;

    @Setter
    private String identifier;
    @Setter
    private String message;

    @Override
    public Optional<String> apply(String name) {
        if (!isValid(name)) {
            return Optional.empty();
        }
        return Optional.of(replacer.replace(message, name));
    }

    boolean isValid(String name) {
        String title = Names.getTitle(name);
        return Objects.equals(identifier, title);
    }
}
