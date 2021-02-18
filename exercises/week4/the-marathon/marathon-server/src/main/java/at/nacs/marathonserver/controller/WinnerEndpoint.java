package at.nacs.marathonserver.controller;

import at.nacs.marathonserver.persistence.Runner;
import at.nacs.marathonserver.persistence.RunnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/winner")
@RequiredArgsConstructor
public class WinnerEndpoint {

    private final RunnerRepository runnerRepository;

    @GetMapping
    Runner winner() {
        return runnerRepository.findFastest().orElse(null);
    }

}
