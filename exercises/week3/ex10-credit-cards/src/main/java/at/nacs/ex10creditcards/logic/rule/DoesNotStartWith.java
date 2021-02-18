package at.nacs.ex10creditcards.logic.rule;

import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class DoesNotStartWith implements Rule {

    private final Set<String> beginnings;

    @Override
    public boolean matches(String number) {
        return beginnings.stream()
                .noneMatch(beginning -> number.startsWith(beginning));
    }
}
