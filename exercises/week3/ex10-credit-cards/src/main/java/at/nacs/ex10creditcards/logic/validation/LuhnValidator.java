package at.nacs.ex10creditcards.logic.validation;

import org.springframework.stereotype.Component;

import java.util.Stack;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
public class LuhnValidator implements Validator{


    @Override
    public boolean isValid(String number) {
        Stack<Integer> digits = getDigits(number);
        Integer checksum = getChecksum(digits);
        return checksum % 10 == 0;
    }

    private Stack<Integer> getDigits(String number) {
        Stack<Integer> digits = new Stack<>();
        Stream.of(number.split(""))
                .map(Integer::valueOf)
                .forEach(digits::push);
        return digits;
    }

    private Integer getChecksum(Stack<Integer> digits) {
        return IntStream.rangeClosed(1, digits.size())
                .mapToObj(isEven())
                .map(operate(digits))
                .mapToInt(toDigitalRoot())
                .sum();
    }

    private IntFunction<Boolean> isEven() {
        return n -> n % 2 == 0;
    }

    private Function<Boolean, Integer> operate(Stack<Integer> digits) {
        return isEven -> isEven ? digits.pop() * 2 : digits.pop();
    }

    private ToIntFunction<Integer> toDigitalRoot() {
        return n -> n > 9 ? n - 9 : n;
    }
}
