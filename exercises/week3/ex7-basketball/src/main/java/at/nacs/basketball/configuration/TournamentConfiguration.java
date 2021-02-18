package at.nacs.basketball.configuration;

import at.nacs.basketball.logic.Tournament;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TournamentConfiguration {

    @Bean
    ApplicationRunner run(Tournament tournament) {
        return args -> tournament.play();
    }

}
