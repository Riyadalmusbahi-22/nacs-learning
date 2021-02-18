package at.nacs.ex10creditcards.configuration;

import at.nacs.ex10creditcards.domain.IssuerInfo;
import at.nacs.ex10creditcards.logic.issuer.Issuer;
import at.nacs.ex10creditcards.logic.util.Issuers;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Configuration
@ConfigurationProperties("creditcard")
@EnableConfigurationProperties({IssuerConfiguration.class})
public class IssuerConfiguration {

    @Setter
    private List<IssuerInfo> issuers;

    @Bean
    Set<Issuer> issuers() {
        return issuers.stream()
                .map(Issuers::from)
                .collect(toSet());
    }

}
