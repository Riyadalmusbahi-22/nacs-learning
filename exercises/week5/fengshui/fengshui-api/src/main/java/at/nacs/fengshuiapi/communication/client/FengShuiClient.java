package at.nacs.fengshuiapi.communication.client;

import at.nacs.fengshuiapi.communication.dto.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class FengShuiClient {

    private final RestTemplate restTemplate;

    @Value("${fengshui.cloud.url}")
    private String url;

    public String get(String query, Map<String, ?> parameters) {
        String address = buildAddress(query, parameters);
        Answer answer = restTemplate.getForObject(address, Answer.class);
        return answer.getResult();
    }

    private String buildAddress(String query, Map<String, ?> parameters) {
        Map<String, Object> uriVariables = Map.of("query", query);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .uriVariables(uriVariables);
        parameters.entrySet().stream()
                .forEach(param -> builder.queryParam(param.getKey(), param.getValue()));
        return builder.build()
                .encode()
                .toString();
    }


}
