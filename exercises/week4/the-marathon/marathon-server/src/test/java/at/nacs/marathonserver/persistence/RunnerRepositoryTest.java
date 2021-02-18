package at.nacs.marathonserver.persistence;

import at.nacs.marathonserver.util.TestRunners;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;


@SpringBootTest(webEnvironment = NONE)
class RunnerRepositoryTest {

    @Autowired
    RunnerRepository runnerRepository;

    @Autowired
    TestRunners testRunners;

    @BeforeEach
    void before() {
        testRunners.getAll().stream()
                .forEach(runnerRepository::add);
    }

    @Test
    void testFastestRunner() {
        assertThat(runnerRepository.findAll().size()).isEqualTo(4);

        Optional<Runner> fastest = runnerRepository.findFastest();

        assertThat(fastest.isPresent()).isTrue();
        String fastestName = testRunners.getFastest().getName();
        assertThat(fastest.get().getName()).isEqualTo(fastestName);
    }

}