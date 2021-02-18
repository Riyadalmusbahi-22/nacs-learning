package at.nacs.ex7insurancemessages.logic.message.template;

import java.util.Optional;

public interface Template {

    Optional<String> apply(String name);
}
