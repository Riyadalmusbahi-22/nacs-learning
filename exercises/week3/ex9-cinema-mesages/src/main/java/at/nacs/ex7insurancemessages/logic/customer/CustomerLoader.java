package at.nacs.ex7insurancemessages.logic.customer;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("customer")
public class CustomerLoader {

    @Getter
    @Setter
    private List<String> names;
}
