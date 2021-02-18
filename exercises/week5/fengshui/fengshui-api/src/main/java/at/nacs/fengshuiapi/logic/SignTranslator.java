package at.nacs.fengshuiapi.logic;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@ConfigurationProperties("fengshui.translation")
public class SignTranslator {

    @Setter
    private Map<String, String> signs;

    public String translate(String sign) {
        return signs.get(sign);
    }

}
