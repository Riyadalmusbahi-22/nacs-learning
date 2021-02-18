package at.nacs.ex7insurancemessages.logic.message;

import at.nacs.ex7insurancemessages.logic.message.template.Template;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@RequiredArgsConstructor
public class TemplateEngine {

    private final List<Template> templates;

    public String getMessage(String name) {
        return templates.stream()
                .map(template -> template.apply(name))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst().orElseThrow(templateNotFound(name));
    }

    private Supplier<IllegalArgumentException> templateNotFound(String name) {
        return () -> new IllegalArgumentException("No template found for name: " + name);
    }

}
