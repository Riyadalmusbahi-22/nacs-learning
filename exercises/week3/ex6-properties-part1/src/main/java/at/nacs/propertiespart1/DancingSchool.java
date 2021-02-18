package at.nacs.propertiespart1;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("dancing-school")
public class DancingSchool {
    
    @Getter
    @Setter
    private List<Ballerina> ballerinas;
    
}
