package at.nacs.ex8rockscissorspaper.ui;

import at.nacs.ex8rockscissorspaper.domain.Move;
import at.nacs.ex8rockscissorspaper.logic.Moves;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Host {

    private final Moves moves;

    public void welcome() {
        System.out.println("Welcome to the Rock Scissors Paper game!");
    }

    public void farewell() {
        System.out.println("See you next time!");
    }

    public void askForMove() {
        System.out.print("Choose a move: (" + moves.asString() + "): ");
    }

    public void askIfWantsToPlayAgain() {
        System.out.print("Do you want to play again? (yes, no): ");
    }

    public void announce(Move move1, Move move2) {
        System.out.println("Player 1 chose " + move1.getName());
        System.out.println("Player 2 chose " + move2.getName());
    }

    public void announce(String result) {
        System.out.println(result);
    }
}
