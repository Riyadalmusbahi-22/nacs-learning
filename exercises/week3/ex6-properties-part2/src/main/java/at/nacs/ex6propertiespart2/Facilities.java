package at.nacs.ex6propertiespart2;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("facilities")
public class Facilities {

    @Setter
    @Getter
    private Sauna sauna;
}
