package at.nacs.ex5thecalculator.controller.operation;

import at.nacs.ex5thecalculator.model.Expression;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Addition implements Operation {

    @Override
    public boolean matches(Expression expression) {
        return Objects.equals("+", expression.getSymbol());
    }

    @Override
    public double apply(Expression expression) {
        return expression.getNumber1() + expression.getNumber2();
    }
}
