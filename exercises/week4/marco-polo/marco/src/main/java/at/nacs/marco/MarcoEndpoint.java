package at.nacs.marco;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/say")
@RequiredArgsConstructor
public class MarcoEndpoint {

    private final RestTemplate restTemplate;

    @Value("${polo.url}")
    private String url;

    @GetMapping("/{message}")
    String get(@PathVariable String message) {
        return restTemplate.postForObject(url, message, String.class);
    }

}
