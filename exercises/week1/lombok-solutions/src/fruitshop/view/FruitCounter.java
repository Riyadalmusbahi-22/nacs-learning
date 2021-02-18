package fruitshop.view;

import fruitshop.model.Fruit;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class FruitCounter {

    public void display(List<Fruit> fruits) {
        System.out.println("These are all our tasteful fruits:");
        fruits.forEach(e -> System.out.println(e.getAmount() + " " + e.getName()));
    }


}
