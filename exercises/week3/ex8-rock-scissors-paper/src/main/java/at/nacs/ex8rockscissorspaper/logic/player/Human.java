package at.nacs.ex8rockscissorspaper.logic.player;

import at.nacs.ex8rockscissorspaper.domain.Move;
import at.nacs.ex8rockscissorspaper.logic.Moves;
import at.nacs.ex8rockscissorspaper.ui.Host;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.Scanner;

@RequiredArgsConstructor
public class Human implements Player {

    private final Moves moves;
    private final Host host;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Move play() {
        Optional<Move> move = Optional.empty();
        while (move.isEmpty()) {
            move = getMove();
        }
        return move.get();
    }

    private Optional<Move> getMove() {
        host.askForMove();
        String choice = scanner.next();
        return moves.from(choice);
    }

    @Override
    public boolean wantsToPlayAgain() {
        host.askIfWantsToPlayAgain();
        String choice = scanner.next();
        return "yes".equalsIgnoreCase(choice);
    }
}
