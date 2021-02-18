package at.nacs.dutchman;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("deadmanschest")
public class DeadMansChest {

    @Getter
    @Setter
    private String item;

}
