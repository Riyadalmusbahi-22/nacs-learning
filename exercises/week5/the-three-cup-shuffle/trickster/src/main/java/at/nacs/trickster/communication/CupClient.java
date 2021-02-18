package at.nacs.trickster.communication;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CupClient {

    private final RestTemplate restTemplate;

    @Value("${cup.server.endpoint}")
    private String url;

    @Value("${cup.server.port.placeholder}")
    private String placeholder;

    @Value("${cup.server.ports}")
    private List<String> ports;

    public boolean get(int number) {
        return restTemplate.getForObject(url, Boolean.class, getUriVariables(number));
    }

    private Map<String, String> getUriVariables(int number) {
        String port = ports.get(number);
        return Map.of(placeholder, port);
    }

    public void put(int number) {
        restTemplate.put(url, null, getUriVariables(number));
    }

    public void delete(int number) {
        restTemplate.delete(url, getUriVariables(number));
    }
}
