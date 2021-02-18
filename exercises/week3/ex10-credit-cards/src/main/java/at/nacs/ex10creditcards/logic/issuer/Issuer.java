package at.nacs.ex10creditcards.logic.issuer;


import at.nacs.ex10creditcards.logic.rule.Rule;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
public class Issuer {

    private final String name;
    private final Set<Rule> rules;

    public Optional<String> from(String number) {
        boolean matches = rules.stream()
                .allMatch(rule -> rule.matches(number));
        return matches ? Optional.of(name) : Optional.empty();
    }

}
