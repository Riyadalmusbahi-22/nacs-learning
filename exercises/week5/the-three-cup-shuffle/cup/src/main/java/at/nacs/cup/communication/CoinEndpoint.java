package at.nacs.cup.communication;

import at.nacs.cup.logic.Cup;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coin")
@RequiredArgsConstructor
public class CoinEndpoint {

    private final Cup cup;

    @GetMapping
    boolean get() {
        return cup.hasCoin();
    }

    @PutMapping
    void put() {
        cup.placeCoin();
    }

    @DeleteMapping
    void delete() {
        cup.removeCoin();
    }

}
