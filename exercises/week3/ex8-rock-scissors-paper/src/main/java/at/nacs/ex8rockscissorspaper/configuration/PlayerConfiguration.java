package at.nacs.ex8rockscissorspaper.configuration;

import at.nacs.ex8rockscissorspaper.domain.Move;
import at.nacs.ex8rockscissorspaper.logic.Moves;
import at.nacs.ex8rockscissorspaper.logic.player.Computer;
import at.nacs.ex8rockscissorspaper.logic.player.Human;
import at.nacs.ex8rockscissorspaper.logic.player.Player;
import at.nacs.ex8rockscissorspaper.ui.Host;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfiguration {

    @Bean
    Player player1(Moves moves, Host host) {
        return new Human(moves, host);
    }

    @Bean
    Player player2(List<Move> moves) {
        return new Computer(moves);
    }

}
