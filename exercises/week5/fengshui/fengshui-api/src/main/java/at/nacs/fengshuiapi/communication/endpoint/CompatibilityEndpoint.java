package at.nacs.fengshuiapi.communication.endpoint;

import at.nacs.fengshuiapi.logic.Compatibilities;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/compatibility")
@RequiredArgsConstructor
public class CompatibilityEndpoint {

    private final Compatibilities compatibilities;

    @GetMapping("/sign/{birthday1}/{birthday2}")
    String sign(@PathVariable LocalDate birthday1, @PathVariable LocalDate birthday2) {
        return compatibilities.sign(birthday1, birthday2);
    }

    @GetMapping("/love/{birthday1}/{birthday2}")
    String love(@PathVariable LocalDate birthday1, @PathVariable LocalDate birthday2) {
        return compatibilities.love(birthday1, birthday2);
    }

}
