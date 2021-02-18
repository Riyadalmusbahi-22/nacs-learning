package at.nacs.trickster.logic;

import at.nacs.trickster.communication.CupClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class Trickster {

    private final CupClient cupClient;

    @Value("${cup.number-of-cups}")
    private int numberOfCups;

    private Random random = new Random();

    public void startGame() {
        removeAllCoins();
        placeOneCoinInRandomCup();
    }

    private void removeAllCoins() {
        IntStream.range(0, numberOfCups)
                .forEach(cupClient::delete);
    }

    private void placeOneCoinInRandomCup() {
        int choice = random.nextInt(numberOfCups);
        cupClient.put(choice);
    }

    public boolean choose(int number) {
        return cupClient.get(number);
    }
}
