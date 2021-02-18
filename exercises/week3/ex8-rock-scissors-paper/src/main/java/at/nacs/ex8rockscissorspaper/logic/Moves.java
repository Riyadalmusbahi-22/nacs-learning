package at.nacs.ex8rockscissorspaper.logic;

import at.nacs.ex8rockscissorspaper.domain.Move;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Moves {

    private final List<Move> moves;

    public String asString() {
        return moves.stream()
                .map(Move::getName)
                .map(StringUtils::capitalize)
                .collect(Collectors.joining(", "));
    }

    public Optional<Move> from(String name) {
        return moves.stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .findFirst();
    }

}
