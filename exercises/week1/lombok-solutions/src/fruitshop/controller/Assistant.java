package fruitshop.controller;

import fruitshop.model.Fruit;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

@UtilityClass
public class Assistant {

    public List<Fruit> count(List<String> fruitNames) {
        return fruitNames.stream()
                .collect(groupingBy(e -> e, counting()))
                .entrySet().stream()
                .map(toFruit())
                .collect(toList());
    }

    private Function<Map.Entry<String, Long>, Fruit> toFruit() {
        return e -> Fruit.builder()
                .name(e.getKey())
                .amount(e.getValue())
                .build();
    }

}
