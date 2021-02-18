package at.nacs.ex7insurancemessages.logic.message.template;

import at.nacs.ex7insurancemessages.logic.NameReplacer;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
@ConfigurationProperties("template.privileged")
public class PrivilegedTemplate implements Template {

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
        String[] parts = name.split(" ");
        return Stream.of(parts)
                .anyMatch(e -> identifier.equals(identifier));
    }
}
