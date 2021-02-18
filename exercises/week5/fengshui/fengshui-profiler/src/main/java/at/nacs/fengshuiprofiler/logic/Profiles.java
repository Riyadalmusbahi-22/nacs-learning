package at.nacs.fengshuiprofiler.logic;

import at.nacs.fengshuiprofiler.communication.client.SignClient;
import at.nacs.fengshuiprofiler.domain.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class Profiles {

    private final SignClient signClient;
    
    public Profile from(LocalDate birthday) {
        return Profile.builder()
                .birthday(birthday)
                .sign(signClient.get(birthday))
                .build();
    }
}
