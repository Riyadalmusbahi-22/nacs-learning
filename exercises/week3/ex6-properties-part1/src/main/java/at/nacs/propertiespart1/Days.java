package at.nacs.propertiespart1;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Days {

    @Getter
    @Value("${days-of-the-week}")
    private List<String> days;
    
}
