package at.nacs.ex6propertiespart2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DancingSchoolTest {

    @Autowired
    DancingSchool dancingSchool;

    @Test
    void getBallerinas() {
        List<Ballerina> ballerinas = dancingSchool.getBallerinas();

        assertEquals(3, ballerinas.size());
    }

    @ParameterizedTest
    @CsvSource({
            "0, Nadia, 1",
            "1, Samara, 2",
            "2, Sasha, 3"
    })
    void testIndividualBallerinas(int index, String name, Integer performance) {
        Ballerina ballerina = dancingSchool.getBallerinas().get(index);

        assertNotNull(ballerina);
        assertEquals(name, ballerina.getName());
        assertEquals(performance, ballerina.getPerformance());
    }

}