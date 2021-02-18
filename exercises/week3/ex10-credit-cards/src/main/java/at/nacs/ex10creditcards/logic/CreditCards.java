package at.nacs.ex10creditcards.logic;

import at.nacs.ex10creditcards.domain.CreditCard;
import at.nacs.ex10creditcards.logic.issuer.Issuer;
import at.nacs.ex10creditcards.logic.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class CreditCards {

    private final Validator validator;
    private final Set<Issuer> issuers;

    public CreditCard get(String number) {
        boolean isValid = validator.isValid(number);
        if (!isValid) {
            return new CreditCard(number, "INVALID");
        }
        return issuers.stream()
                .map(issuer -> issuer.from(number))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(issuer -> new CreditCard(number, issuer))
                .findFirst()
                .orElse(new CreditCard(number, "UNKNOWN"));
    }
}
