package at.nacs.ex10creditcards.logic.rule;

import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class Length implements Rule {

    private final Set<Integer> lengths;

    @Override
    public boolean matches(String number) {
        return lengths.stream()
                .anyMatch(length -> length.equals(number.length()));
    }
}
