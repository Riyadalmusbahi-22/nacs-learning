package at.nacs.fengshuiprofiler.communication.endpoint;

import at.nacs.fengshuiprofiler.domain.Match;
import at.nacs.fengshuiprofiler.domain.Profile;
import at.nacs.fengshuiprofiler.logic.Matches;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/match")
@RequiredArgsConstructor
public class MatchEndpoint {

    private final Matches matches;

    @GetMapping("/{birthday1}/{birthday2}")
    Match get(@PathVariable LocalDate birthday1, @PathVariable LocalDate birthday2) {
        return matches.from(birthday1, birthday2);
    }
}
