package at.nacs.marathonserver.util;

import at.nacs.marathonserver.persistence.Runner;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties("test")
public class TestRunners {

    @Setter
    private List<Runner> runners;

    public List<Runner> getAll() {
        return new ArrayList<>(runners);
    }

    public Runner getOne() {
        return runners.get(0);
    }

    public Runner getFastest() {
        return runners.get(3);
    }

}
