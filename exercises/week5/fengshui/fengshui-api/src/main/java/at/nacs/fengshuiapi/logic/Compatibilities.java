package at.nacs.fengshuiapi.logic;

import at.nacs.fengshuiapi.communication.client.FengShuiClient;
import at.nacs.fengshuiapi.communication.url.Params;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@ConfigurationProperties("fengshui.query.compatibility")
public class Compatibilities {

    private final FengShuiClient fengShuiClient;
    private final Signs signs;
    private final SignTranslator signTranslator;

    @Setter
    private String sign;
    @Setter
    private String love;

    public String sign(LocalDate birthday1, LocalDate birthday2) {
        String sign1 = toSign(birthday1);
        String sign2 = toSign(birthday2);
        return fengShuiClient.get(sign, Params.from(sign1, sign2));
    }

    private String toSign(LocalDate birthday) {
        String sign = signs.getSign(birthday);
        String signNumber = signTranslator.translate(sign);
        return signNumber;
    }

    public String love(LocalDate birthday1, LocalDate birthday2) {
        return fengShuiClient.get(love, Params.from(birthday1, birthday2));
    }
    
}
