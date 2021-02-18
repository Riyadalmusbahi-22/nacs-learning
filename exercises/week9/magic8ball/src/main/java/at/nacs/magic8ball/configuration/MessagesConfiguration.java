package at.nacs.magic8ball.configuration;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("magic8ball")
public class MessagesConfiguration {

  @Setter
  private List<String> messages;

  @Bean
  List<String> messages() {
    return messages;
  }

}
