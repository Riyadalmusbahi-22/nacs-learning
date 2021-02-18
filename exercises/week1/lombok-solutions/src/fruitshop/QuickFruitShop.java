package fruitshop;

import fruitshop.controller.FileReader;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class QuickFruitShop {

    public static void main(String[] args) {
        System.out.println("Here are our tasteful fruits:");
        FileReader.lines("fruitshop/file/delivery.txt")
                .collect(groupingBy(e -> e, counting()))
                .entrySet().stream()
                .map(e -> e.getValue() + " " + e.getKey())
                .forEach(System.out::println);
        
        // get list of names (file reader)
        // give list of names and get list of fruit (fruit and assistant)
        // give the list of fruit and display it
    }

}
