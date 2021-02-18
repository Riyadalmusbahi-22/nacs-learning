package fruitshop.controller;

import fruitshop.model.Fruit;
import fruitshop.view.FruitCounter;

import java.util.List;

public class FruitShopApp {

    public static void main(String[] args) {
        String filePath = "fruitshop/file/delivery.txt";
        List<String> fruitNames = FileReader.asList(filePath);
        List<Fruit> fruits = Assistant.count(fruitNames);
        FruitCounter.display(fruits);
    }

}
