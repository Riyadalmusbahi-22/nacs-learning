package fruitshop.controller;

import fruitshop.model.Fruit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AssistantTest {

    @ParameterizedTest
    @CsvSource({
            "1, 2, apple orange orange",
            "2, 3, apple apple orange orange orange"
    })
    void count(long numberOfApples, long numberOfOranges, String input) {
        String[] split = input.split(" ");
        List<String> fruitNames = List.of(split);

        List<Fruit> fruits = Assistant.count(fruitNames);

        assertEquals(2, fruits.size());

        Fruit apples = find("apple", fruits);
        assertEquals(numberOfApples, apples.getAmount());

        Fruit oranges = find("orange", fruits);
        assertEquals(numberOfOranges, oranges.getAmount());
    }

    private Fruit find(String name, List<Fruit> fruits) {
        Optional<Fruit> fruit = fruits.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst();
        assertTrue(fruit.isPresent());
        return fruit.get();
    }
}