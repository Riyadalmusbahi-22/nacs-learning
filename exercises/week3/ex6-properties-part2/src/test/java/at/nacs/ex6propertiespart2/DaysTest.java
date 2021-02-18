package at.nacs.ex6propertiespart2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DaysTest {

    @Autowired
    Days days;

    @Test
    void getDays() {
        List<String> daysOfWeek = days.getDays();

        assertEquals(7, daysOfWeek.size());

        String actual = daysOfWeek.stream()
                .collect(Collectors.joining(", "));
        String expected = "Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday";
        assertEquals(expected, actual);
    }
}