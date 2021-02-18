package at.nacs.ex10creditcards.logic;

import at.nacs.ex10creditcards.domain.CreditCard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CreditCardsTest {

    @Autowired
    CreditCards creditCards;

    @DisplayName("Credit card issuer")
    @ParameterizedTest(name = "\"{1}\" should be {0}")
    @CsvSource({
            "INVALID, 45397351314492852",
            "UNKNOWN, 2720997950404063",
            "Visa, 4024007178072186, ",
            "Visa, 4091786571905922",
            "Visa, 4024007155242161199",
            "Discover, 6011303313776033",
            "Discover, 6011459640212181",
            "Discover, 6011165993428028656",
            "Visa Electron, 4913925746427299",
            "Visa Electron, 4913925746427299",
            "Visa Electron, 4844783537679998",
            "MasterCard, 5519822285312351",
            "MasterCard, 5341855952267338",
            "MasterCard, 5307085475040119",
            "InstaPayment, 6389386128470227",
            "InstaPayment, 6377913609524117",
            "InstaPayment, 6391193993918850",
            "American Express, 344293227024607",
            "American Express, 345710285757454",
            "American Express, 375506403259784",
            "Maestro, 5020662886126624",
            "Maestro, 5038813198974843",
            "Maestro, 6761195355509054",
    })
    void testRightIssuer(String expected, String number) {
        CreditCard creditCard = creditCards.get(number);

        assertNotNull(creditCard);
        assertEquals(number, creditCard.getNumber());
        assertEquals(expected, creditCard.getIssuer());
    }

}