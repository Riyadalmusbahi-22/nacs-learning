package at.nacs.ex8rockscissorspaper.logic;

import at.nacs.ex8rockscissorspaper.domain.Move;
import at.nacs.ex8rockscissorspaper.logic.player.Player;
import at.nacs.ex8rockscissorspaper.ui.Host;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Game {

    private final Player player1;
    private final Player player2;
    private final Judge judge;
    private final Host host;

    public void play() {
        host.welcome();
        boolean play = true;
        while (play) {
            playOneRound();
            play = ask();
        }
        host.farewell();
    }

    private void playOneRound() {
        Move move1 = player1.play();
        Move move2 = player2.play();
        host.announce(move1, move2);
        String result = this.judge.judge(move1, move2);
        host.announce(result);
    }

    private boolean ask() {
        return player1.wantsToPlayAgain() && player2.wantsToPlayAgain();
    }
}
