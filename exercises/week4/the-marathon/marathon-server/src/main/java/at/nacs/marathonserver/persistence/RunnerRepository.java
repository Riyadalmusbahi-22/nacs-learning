package at.nacs.marathonserver.persistence;

import org.springframework.stereotype.Component;

import java.util.*;

import static java.util.Comparator.comparing;

@Component
public class RunnerRepository {

    private Set<Runner> runners = new HashSet<>();

    public void add(Runner runner) {
        runners.add(runner);
    }

    public List<Runner> findAll() {
        return new ArrayList<>(runners);
    }

    public Optional<Runner> findFastest() {
        return runners.stream()
                .min(comparing(Runner::getTime));
    }
}
