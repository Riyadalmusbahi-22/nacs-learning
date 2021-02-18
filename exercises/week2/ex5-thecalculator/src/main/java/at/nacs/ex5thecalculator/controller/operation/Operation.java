package at.nacs.ex5thecalculator.controller.operation;


import at.nacs.ex5thecalculator.model.Expression;

public interface Operation {

    boolean matches(Expression expression);

    double apply(Expression expression);

}
