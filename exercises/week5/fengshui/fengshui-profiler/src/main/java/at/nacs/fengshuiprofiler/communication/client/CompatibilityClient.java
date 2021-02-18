package at.nacs.fengshuiprofiler.communication.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class CompatibilityClient {

    private final RestTemplate restTemplate;

    @Value("${fengshui.api.endpoints.compatibility.sign}")
    private String sign;

    @Value("${fengshui.api.endpoints.compatibility.love}")
    private String love;

    public String sign(LocalDate birthday1, LocalDate birthday2) {
        String url = sign + "/" + birthday1 + "/" + birthday2;
        return restTemplate.getForObject(url, String.class);
    }

    public String love(LocalDate birthday1, LocalDate birthday2) {
        String url = love + "/" + birthday1 + "/" + birthday2;
        return restTemplate.getForObject(url, String.class);
    }
}
