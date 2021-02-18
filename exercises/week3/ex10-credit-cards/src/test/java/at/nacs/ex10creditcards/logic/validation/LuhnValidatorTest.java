package at.nacs.ex10creditcards.logic.validation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class LuhnValidatorTest {

    @Autowired
    Validator luhnValidator;

    @ParameterizedTest(name = "start #{index} with [{arguments}]")
    @ValueSource(strings = {
            "378282246310005", "371449635398431", "5555555555554444",
            "5105105105105100", "4111111111111111", "4012888888881881",
            "4373631987146720", "4485832439079635", "4929284097886035491",
            "5416395829812727", "2720997950404063", "2720994996921655",

    })
    void isValid(String number) {
        assertTrue(luhnValidator.isValid(number));
    }

    @Test
    void isInvalid() {
        assertFalse(luhnValidator.isValid("37828224631000"));
    }
}