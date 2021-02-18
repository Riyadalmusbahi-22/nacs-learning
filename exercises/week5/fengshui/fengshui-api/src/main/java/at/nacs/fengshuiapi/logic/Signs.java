package at.nacs.fengshuiapi.logic;

import at.nacs.fengshuiapi.communication.client.FengShuiClient;
import at.nacs.fengshuiapi.communication.url.Params;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class Signs {

    private final FengShuiClient fengShuiClient;

    @Value("${fengshui.query.sign}")
    private String query;

    public String getSign(LocalDate birthday) {
        return fengShuiClient.get(query, Params.from(birthday));
    }


}
