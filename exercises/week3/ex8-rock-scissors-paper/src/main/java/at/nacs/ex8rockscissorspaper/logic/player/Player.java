package at.nacs.ex8rockscissorspaper.logic.player;

import at.nacs.ex8rockscissorspaper.domain.Move;

public interface Player {

    Move play();

    boolean wantsToPlayAgain();

}
