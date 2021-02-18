package at.nacs.ex7insurancemessages.configuration;

import at.nacs.ex7insurancemessages.logic.CinemaMessageSender;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    ApplicationRunner run(CinemaMessageSender sender) {
        return args -> sender.send();
    }

}
