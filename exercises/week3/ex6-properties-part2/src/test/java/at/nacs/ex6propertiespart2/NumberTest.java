package at.nacs.ex6propertiespart2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class NumberTest {

    @Autowired
    Number number;

    @Test
    void getNumber() {
        assertEquals(Integer.valueOf(369), number.getNumber());
    }
}