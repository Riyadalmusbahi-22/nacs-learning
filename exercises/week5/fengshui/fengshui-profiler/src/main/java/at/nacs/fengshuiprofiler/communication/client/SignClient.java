package at.nacs.fengshuiprofiler.communication.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class SignClient {

    private final RestTemplate restTemplate;

    @Value("${fengshui.api.endpoints.sign}")
    private String url;

    public String get(LocalDate birthday) {
        String signUrl = url + "/" + birthday.toString();
        return restTemplate.getForObject(signUrl, String.class);
    }

}
