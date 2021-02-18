package at.nacs.fengshuiprofiler.logic;

import at.nacs.fengshuiprofiler.communication.client.CompatibilityClient;
import at.nacs.fengshuiprofiler.domain.Match;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class Matches {
    
    private final Profiles profiles;
    private final CompatibilityClient compatibilityClient;

    public Match from(LocalDate birthday1, LocalDate birthday2) {
        return Match.builder()
                .profile1(profiles.from(birthday1))
                .profile2(profiles.from(birthday2))
                .signCompatibility(compatibilityClient.sign(birthday1, birthday2))
                .loveCompatibility(compatibilityClient.love(birthday1, birthday2))
                .build();
    }
}
