package at.nacs.ex5thecalculator.controller;

import at.nacs.ex5thecalculator.model.Expression;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

@Component
public class Expressions {

    public Expression from(String expression) {
        Queue<String> elements = toElements(expression);
        if (elements.size() != 3) {
            throw new IllegalArgumentException("Expected 3 elements but received " + elements.size());
        }
        return Expression.builder()
                .number1(Double.valueOf(elements.poll()))
                .symbol(elements.poll())
                .number2(Double.valueOf(elements.poll()))
                .build();
    }

    private Queue<String> toElements(String expression) {
        return Stream.of(expression.split(" "))
                .collect(toCollection(LinkedList::new));
    }

}
