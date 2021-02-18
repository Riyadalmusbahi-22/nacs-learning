package at.nacs.socialnetwork.dataset;

import at.nacs.socialnetwork.persistence.Person;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("dataset")
public class PersonsConfiguration {

    @Setter
    List<Person> persons;

    @Bean
    List<Person> persons() {
        return persons;
    }

}
