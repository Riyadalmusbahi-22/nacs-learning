package at.nacs.ex8rockscissorspaper.configuration;

import at.nacs.ex8rockscissorspaper.logic.Game;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfiguration {

    @Bean
    ApplicationRunner run(Game game) {
        return args -> game.play();
    }
}
