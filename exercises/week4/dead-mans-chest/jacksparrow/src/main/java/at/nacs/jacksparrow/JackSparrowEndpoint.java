package at.nacs.jacksparrow;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/deadmanschest")
@RequiredArgsConstructor
public class JackSparrowEndpoint {

    private final RestTemplate restTemplate;

    @Value("${tiadalma.url}")
    private String tiadalmaUrl;

    @Value("${dutchman.endpoint}")
    private String dutchmanEndpoint;

    @GetMapping
    DeadMansChest get() {
        String dutchmanUrl = restTemplate.getForObject(tiadalmaUrl, String.class);
        String deadmanschestUrl = dutchmanUrl + dutchmanEndpoint;
        return restTemplate.getForObject(deadmanschestUrl, DeadMansChest.class);
    }

}
