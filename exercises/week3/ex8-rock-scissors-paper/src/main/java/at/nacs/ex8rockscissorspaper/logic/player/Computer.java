package at.nacs.ex8rockscissorspaper.logic.player;

import at.nacs.ex8rockscissorspaper.domain.Move;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class Computer implements Player {

    private final List<Move> moves;
    private Random random = new Random();

    @Override
    public Move play() {
        int choice = random.nextInt(moves.size());
        return moves.get(choice);
    }

    @Override
    public boolean wantsToPlayAgain() {
        return true;
    }
}
