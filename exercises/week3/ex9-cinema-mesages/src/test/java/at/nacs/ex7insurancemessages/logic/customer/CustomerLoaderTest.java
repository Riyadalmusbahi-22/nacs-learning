package at.nacs.ex7insurancemessages.logic.customer;

import at.nacs.ex7insurancemessages.logic.customer.CustomerLoader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CustomerLoaderTest {

    @Autowired
    CustomerLoader customerLoader;

    @Test
    void getNames() {
        List<String> names = customerLoader.getNames();

        assertEquals(3, names.size());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Pete", "Paul", "Laura"})
    void testIndividualNames(String name) {
        List<String> names = customerLoader.getNames();

        assertTrue(names.contains(name));
    }
}