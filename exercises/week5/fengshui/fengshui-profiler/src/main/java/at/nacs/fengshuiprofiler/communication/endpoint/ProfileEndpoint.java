package at.nacs.fengshuiprofiler.communication.endpoint;

import at.nacs.fengshuiprofiler.domain.Profile;
import at.nacs.fengshuiprofiler.logic.Profiles;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileEndpoint {
    
    private final Profiles profiles;

    @GetMapping("/{birthday}")
    Profile get(@PathVariable LocalDate birthday) {
        return profiles.from(birthday);
    }
}
