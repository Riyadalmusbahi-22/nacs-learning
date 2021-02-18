package at.nacs.ex5thecalculator.controller;

import at.nacs.ex5thecalculator.controller.operation.Operation;
import at.nacs.ex5thecalculator.model.Expression;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
public class Calculator {

    private final List<Operation> operations;

    public double calculate(Expression expression) {
        return operations.stream()
                .filter(operation -> operation.matches(expression))
                .map(operation -> operation.apply(expression))
                .findFirst().orElseThrow(wrongOperation(expression));
    }

    private Supplier<IllegalArgumentException> wrongOperation(Expression expression) {
        return () -> new IllegalArgumentException("Not supported operation: " + expression.getSymbol());
    }


}
