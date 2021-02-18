package at.nacs.ex6propertiespart2;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Number {

    @Getter
    @Value("${number}")
    private Integer number;

}
