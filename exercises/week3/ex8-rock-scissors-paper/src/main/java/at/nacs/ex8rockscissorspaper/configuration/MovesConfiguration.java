package at.nacs.ex8rockscissorspaper.configuration;

import at.nacs.ex8rockscissorspaper.domain.Move;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("game")
public class MovesConfiguration {

    @Setter
    private List<Move> moves;

    @Bean
    List<Move> available() {
        return moves;
    }

}
