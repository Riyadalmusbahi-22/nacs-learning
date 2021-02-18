package at.nacs.ex3thecursedcoin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JackSparrow {

    private final LegendaryCompass legendaryCompass;

    public String findCursedCoin() {
        CursedCoin cursedCoin = legendaryCompass.findCursedCoin();
        return "I found the " + cursedCoin.getClass().getSimpleName() + "!";
    }

}
